package de.tuberlin.sqe.ss18.reqexchange.git.service;

import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import org.eclipse.jgit.api.CherryPickResult;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.*;
import org.joda.time.DateTime;

import java.net.URI;

public class DefaultGitService implements GitService {

    private PathService pathService;
    private GitPropertiesService gitPropertiesService;

    private CredentialsProvider credentialsProvider;

    @Inject
    public DefaultGitService(
            PathService pathService,
            GitPropertiesService gitPropertiesService) {
        this.pathService = pathService;
        this.gitPropertiesService = gitPropertiesService;

        credentialsProvider = new UsernamePasswordCredentialsProvider(
                gitPropertiesService.getUsername(),
                gitPropertiesService.getPassword());
    }

    public boolean clone(Project project) {
        try (Git git = Git.cloneRepository()
                     .setURI(getRemoteGitRepositoryURI(project).toString())
                     .setDirectory(project.getLocalGitRepositoryPath().toFile())
                     .call()) {
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean canPull(Project project) {
        try (Git git = getLocalGitRepository(project)) {
            FetchResult fetchResult = git.fetch().setDryRun(true).call();
            return !fetchResult.getAdvertisedRefs().isEmpty();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pull(Project project) {
        if (!canPull(project)) {
            return false;
        }

        try (Git git = getLocalGitRepository(project)) {
            git.pull().call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();;
            return false;
        }
    }

    public boolean addAllFiles(Project project) {
        try (Git git = getLocalGitRepository(project)) {
            git.add().addFilepattern(".").call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //TODO: muss falsch sein, ist nur bei Add und remove angesprungen
//    public boolean canCommit(ProjectInfo projectInfo) {
//        Git git = getLocalGitRepository(projectInfo);
//        try {
//            List<DiffEntry> diffEntries = git.diff().call();
//            return !diffEntries.isEmpty();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public boolean commitAll(Project project) {

        try (Git git = getLocalGitRepository(project)) {
            git.commit()
                    .setAll(true)
                    .setMessage(getCommitMessage())
                    .call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private String getCommitMessage() {
        return "Commit" +
                " am " + new DateTime().toString("dd.MM.yyy") +
                " um " + new DateTime().toString("HH:mm:ss");
    }

//    public boolean checkout(String name) {
//        try {
//            Git git = getLocalGitRepository(name);
//
//
//            git.checkout().setAllPaths(true).call();
//
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public boolean canPush(Project project) {
        try (Git git = getLocalGitRepository(project)) {
            CherryPickResult cherryPickResult = git.cherryPick().call();
            return !cherryPickResult.getCherryPickedRefs().isEmpty();
            //BranchTrackingStatus branchTrackingStatus = BranchTrackingStatus.of(git.getRepository(), "master");
            //return branchTrackingStatus.getAheadCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pushAll(Project project) {
        //if (!canPush(name)) {
        //    return false;
        //}

        try (Git git = getLocalGitRepository(project)) {
            git.push()
                    .setPushAll()
                    .setCredentialsProvider(credentialsProvider)
                    .call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean executeAddCommitPushAll(Project project) {
        try (Git git = getLocalGitRepository(project)) {

            git.add().addFilepattern(".").call();

            git.commit().setAll(true).setMessage(getCommitMessage()).call();

            git.push().setPushAll().setCredentialsProvider(credentialsProvider).call();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Git getLocalGitRepository(Project project) {
        try {
            return Git.open(project.getLocalGitRepositoryPath().toFile());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private URI getRemoteGitRepositoryURI(Project project) {
        return URI.create("https://github.com/cfengler/" + project.getName() + ".git");
    }
//
}

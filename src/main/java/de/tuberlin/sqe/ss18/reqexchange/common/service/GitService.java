package de.tuberlin.sqe.ss18.reqexchange.common.service;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Collection;

@Component
public class GitService {

    private PathService pathService;
    private GitPropertiesService gitPropertiesService;

    private CredentialsProvider credentialsProvider;

    @Autowired
    public GitService(PathService pathService, GitPropertiesService gitPropertiesService) {
        this.pathService = pathService;
        this.gitPropertiesService = gitPropertiesService;

        credentialsProvider = new UsernamePasswordCredentialsProvider(
                gitPropertiesService.getUsername(),
                gitPropertiesService.getPassword());
    }

    public boolean clone(ProjectInfo projectInfo) {
        try {
            Git.cloneRepository()
                    .setURI(getRemoteGitRepositoryURI(projectInfo).toString())
                    .setDirectory(pathService.getLocalGitRepositoryPath(projectInfo).toFile())
                    .call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean canPull(ProjectInfo projectInfo) {
        try {
            Git git = getLocalGitRepository(projectInfo);

            FetchResult fetchResult = git.fetch().call();

            Collection<TrackingRefUpdate> trackingRefUpdates = fetchResult.getTrackingRefUpdates();
            return !trackingRefUpdates.isEmpty();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pull(ProjectInfo projectInfo) {
        if (!canPull(projectInfo)) {
            return false;
        }

        Git git = getLocalGitRepository(projectInfo);
        try {
            git.pull().call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();;
            return false;
        }
    }

    public boolean addAllFiles(ProjectInfo projectInfo) {
        Git git = getLocalGitRepository(projectInfo);

        try {
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

    public boolean commitAll(ProjectInfo projectInfo) {

        try {
            Git git = getLocalGitRepository(projectInfo);
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
//
//    public boolean canPush(String name) {
//        Git git = getLocalGitRepository(name);
//        try {
//            BranchTrackingStatus branchTrackingStatus = BranchTrackingStatus.of(git.getRepository(), "master");
//            return branchTrackingStatus.getAheadCount() > 0;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
    public boolean pushAll(ProjectInfo projectInfo) {
        //if (!canPush(name)) {
        //    return false;
        //}

        try {
            Git git = getLocalGitRepository(projectInfo);
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


    public boolean executeAddCommitPushAll(ProjectInfo projectInfo) {
        try (Git git = getLocalGitRepository(projectInfo)) {

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

    private Git getLocalGitRepository(ProjectInfo projectInfo) {
        try {
            return Git.open(pathService.getLocalGitRepositoryPath(projectInfo).toFile());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private URI getRemoteGitRepositoryURI(ProjectInfo projectInfo) {
        return URI.create("https://github.com/cfengler/" + projectInfo.getName() + ".git");
    }
//
}

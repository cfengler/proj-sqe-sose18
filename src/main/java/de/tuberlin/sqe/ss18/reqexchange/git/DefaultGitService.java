package de.tuberlin.sqe.ss18.reqexchange.git;

import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.common.PathService;
import de.tuberlin.sqe.ss18.reqexchange.project.Project;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.merge.MergeStrategy;
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

    public boolean checkPullNeeded(Project project) {
        //TODO: not so cool
        try (Git git = getLocalGitRepository(project)) {
            FetchResult fetchResult = git.fetch().setRemote("origin").call();
            if (!fetchResult.getTrackingRefUpdates().isEmpty()) {
                return true;
            }
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pull(Project project) {
        if (!project.isPullNeeded()) {
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

    @Override
    public boolean pullMergeStrategyOur(Project project) {
        try (Git git = getLocalGitRepository(project)) {
            git.pull().setStrategy(MergeStrategy.OURS).call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pushAll(Project project) {
        try (Git git = getLocalGitRepository(project)) {
            pullMergeStrategyOur(project);
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

    public boolean resetHard(Project project) {
        try(Git git = getLocalGitRepository(project)) {
            git.reset().setMode(ResetCommand.ResetType.HARD).call();

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
        //TODO: change to common git provider
        return project.getRemoteGitRepositoryURI() == null
                ? URI.create("https://github.com/cfengler/" + project.getName() + ".git")
                : project.getRemoteGitRepositoryURI();
    }
}
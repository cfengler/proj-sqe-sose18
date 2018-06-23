package de.tuberlin.sqe.ss18.reqexchange.git.service;

import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.*;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.joda.time.DateTime;

import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    public void listDiffEntries(Project project) {
        try (Git git = getLocalGitRepository(project)) {
            FetchResult fetchResult = git.fetch().setRemote("origin").call();

            Repository repository = git.getRepository();
            ObjectId fetchHead = repository.resolve("FETCH_HEAD^{tree}");
            ObjectId head = repository.resolve("HEAD^{tree}");

            ObjectReader reader = repository.newObjectReader();
            CanonicalTreeParser currentTreeParser = new CanonicalTreeParser();
            currentTreeParser.reset(reader, head);
            CanonicalTreeParser fetchTreeParser = new CanonicalTreeParser();
            fetchTreeParser.reset(reader, fetchHead);

            List<DiffEntry> diffEntries = git.diff().setShowNameAndStatusOnly(true)
                    .setNewTree(fetchTreeParser)
                    .setOldTree(currentTreeParser)
                    .call();

            for (DiffEntry diffEntry : diffEntries) {
                System.out.println(diffEntry.toString());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkPullNeeded(Project project) {
        try (Git git = getLocalGitRepository(project)) {
            FetchResult fetchResult = git.fetch().setRemote("origin").call();
            Repository repository = git.getRepository();
            ObjectId fetchHead = repository.resolve("FETCH_HEAD^{tree}");
            ObjectId head = repository.resolve("HEAD^{tree}");

            ObjectReader reader = repository.newObjectReader();
            CanonicalTreeParser currentTreeParser = new CanonicalTreeParser();
            currentTreeParser.reset(reader, head);
            CanonicalTreeParser fetchTreeParser = new CanonicalTreeParser();
            fetchTreeParser.reset(reader, fetchHead);

            List<DiffEntry> diffEntries = git.diff().setShowNameAndStatusOnly(true)
                    .setNewTree(fetchTreeParser)
                    .setOldTree(currentTreeParser)
                    .call();

            if (diffEntries.isEmpty()) {
                return false;
            }

            for (DiffEntry diffEntry : diffEntries) {
                System.out.println("Entry: " + diffEntry + ", from: " + diffEntry.getOldId() + ", to: " + diffEntry.getNewId());
                try (DiffFormatter formatter = new DiffFormatter(System.out)) {
                    formatter.setRepository(repository);
                    formatter.format(diffEntry);
                }
            }

            return diffEntries.stream().anyMatch(diffEntry -> {
                return !diffEntry.getOldId().equals(diffEntry.getNewId());
            });

            //return !diffs.isEmpty();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pull(Project project) {
        if (!checkPullNeeded(project)) {
            return true;
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

    public boolean executeCommitPushAll(Project project) {
        try(Git git = getLocalGitRepository(project)) {
            git.commit().setAll(true).setMessage(getCommitMessage()).call();
            git.push().setPushAll().setCredentialsProvider(credentialsProvider).call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
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

    public boolean pushAll(Project project) {
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

    public boolean executePullMergeWithStrategyOur(Project project) {
        try(Git git = getLocalGitRepository(project)) {

            MergeResult mergeResult = git.merge().setStrategy(MergeStrategy.OURS).call();
            //TODO: kann was schief gehen?
            mergeResult.toString();
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

    public boolean fetch(Project project) {
        try (Git git = getLocalGitRepository(project)) {
            FetchResult fetchResult = git.fetch().setRemote("origin").call();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean addAllFiles(Project project) {
//        try (Git git = getLocalGitRepository(project)) {
//            git.add().addFilepattern(".").call();
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

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
        return URI.create("https://github.com/cfengler/" + project.getName() + ".git");
    }
//
}

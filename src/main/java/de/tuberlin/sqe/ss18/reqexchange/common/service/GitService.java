//package de.tuberlin.sqe.ss18.reqexchange.common.service;
//
//import org.eclipse.jgit.api.Git;
//import org.eclipse.jgit.diff.DiffEntry;
//import org.eclipse.jgit.lib.BranchTrackingStatus;
//import org.eclipse.jgit.transport.*;
//import org.joda.time.DateTime;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Collection;
//import java.util.List;
//
//@Component
//public class GitService {
//
//    private PathService pathService;
//    private GitPropertiesService gitPropertiesService;
//
//    private CredentialsProvider credentialsProvider;
//
//    @Autowired
//    public GitService(PathService pathService, GitPropertiesService gitPropertiesService) {
//        this.pathService = pathService;
//        this.gitPropertiesService = gitPropertiesService;
//
//        credentialsProvider = new UsernamePasswordCredentialsProvider(
//                gitPropertiesService.getUsername(),
//                gitPropertiesService.getPassword());
//    }
//
//    public boolean clone(String name) {
//        try {
//            Git.cloneRepository()
//                    .setURI(getRemoteGitRepository(name))
//                    .setDirectory(getLocalGitRepositoryFile(name))
//                    .call();
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean canPull(String name) {
//        try {
//            Git git = getLocalGitRepository(name);
//
//            FetchResult fetchResult = git
//                    .fetch()
//                    .call();
//
//            Collection<TrackingRefUpdate> trackingRefUpdates = fetchResult.getTrackingRefUpdates();
//            return !trackingRefUpdates.isEmpty();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean pull(String name) {
//        if (!canPull(name)) {
//            return false;
//        }
//
//        try {
//            Git git = getLocalGitRepository(name);
//            git.pull().call();
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();;
//            return false;
//        }
//    }
//
//    public boolean canCommit(String name) {
//        try {
//            Git git = getLocalGitRepository(name);
//            List<DiffEntry> diffEntries = git.diff().call();
//            return !diffEntries.isEmpty();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean commit(String name) {
//        try {
//            Git git = getLocalGitRepository(name);
//            git.commit()
//                    .setAll(true)
//                    .setMessage("Commit" +
//                            " am " + new DateTime().toString("dd.MM.yyy") +
//                            " um " + new DateTime().toString("HH:mm:ss"))
//                    .call();
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
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
//    public boolean push(String name) {
//        if (!canPush(name)) {
//            return false;
//        }
//
//        try {
//            Git git = getLocalGitRepository(name);
//            git.push()
//                    .setCredentialsProvider(credentialsProvider)
//                    .call();
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    private Git getLocalGitRepository(String name) {
//        try {
//            return Git.open(getLocalGitRepositoryFile(name));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private File getLocalGitRepositoryFile(String name) {
//        return pathService.getProjectsPath().resolve(name).toFile();
//    }
//
//    private String getRemoteGitRepository(String name) {
//        return "https://github.com/cfengler/" + name + ".git";
//    }
//
//}

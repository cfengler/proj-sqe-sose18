package de.tuberlin.sqe.ss18.reqexchange.git.service;

import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;

public interface GitService {

    boolean clone(Project project);
    boolean executeAddCommitPushAll(Project project);

    boolean checkPullNeeded(Project project);
    boolean pull(Project project);

    boolean executeCommitPushAll(Project project);
    //boolean addAllFiles(Project project);
    boolean commitAll(Project project);
    //boolean canPush(Project project);
    //boolean pushAll(Project project);

    boolean pullMergeStrategyOur(Project project);

    boolean pushAll(Project project);
    boolean executePullMergeWithStrategyOur(Project project);
    boolean resetHard(Project project);

    boolean fetch(Project project);


    //TODO: debug
    void listDiffEntries(Project project);

}

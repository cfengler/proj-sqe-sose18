package de.tuberlin.sqe.ss18.reqexchange.git;

import de.tuberlin.sqe.ss18.reqexchange.project.Project;

public interface GitService {

    boolean clone(Project project);
    boolean executeAddCommitPushAll(Project project);

    boolean checkPullNeeded(Project project);
    boolean pull(Project project);

    boolean commitAll(Project project);

    boolean pullMergeStrategyOur(Project project);

    boolean pushAll(Project project);
    boolean resetHard(Project project);
}

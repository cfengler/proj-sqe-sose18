package de.tuberlin.sqe.ss18.reqexchange.git.service;

import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;

public interface GitService {

    boolean clone(Project project);
    boolean canPull(Project project);
    boolean pull(Project project);
    boolean addAllFiles(Project project);
    boolean commitAll(Project project);
    boolean canPush(Project project);
    boolean pushAll(Project project);
    boolean executeAddCommitPushAll(Project project);

}

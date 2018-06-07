package de.tuberlin.sqe.ss18.reqexchange.client.data.repository;

import de.tuberlin.sqe.ss18.reqexchange.client.data.domain.ProjectInfo;

public class ClientProjectRepositoryFactory {
    public ClientProjectRepository getProjectRepository(ProjectInfo projectInfo) {
        //TODO: switch case on projectInfo.type and return specific repository
        return null;
    }
}

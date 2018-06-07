package de.tuberlin.sqe.ss18.reqexchange.server.data.repository;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Long> {

}

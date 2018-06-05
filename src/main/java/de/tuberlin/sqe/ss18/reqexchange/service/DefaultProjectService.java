//package de.tuberlin.sqe.ss18.reqexchange.service;
//
//import de.tuberlin.sqe.ss18.reqexchange.data.domain.Project;
//import de.tuberlin.sqe.ss18.reqexchange.data.repository.ProjectRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DefaultProjectService implements ProjectService {
//
//    private ProjectRepository projectRepository;
//
//    @Autowired
//    public DefaultProjectService(ProjectRepository projectRepository) {
//        this.projectRepository = projectRepository;
//    }
//
//    public void addProject(Project project) {
//        projectRepository.save(project);
//    }
//
//    public List<Project> getProjects() {
//        List<Project> result = new ArrayList<Project>();
//        projectRepository.findAll().forEach(result::add);
//        return result;
//    }
//}

package com.shangchenhsieh.udemyCoursePPMT.services;

import com.shangchenhsieh.udemyCoursePPMT.domain.Backlog;
import com.shangchenhsieh.udemyCoursePPMT.domain.Project;
import com.shangchenhsieh.udemyCoursePPMT.exceptions.ProjectIdException;
import com.shangchenhsieh.udemyCoursePPMT.repositories.BacklogRepository;
import com.shangchenhsieh.udemyCoursePPMT.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

            if (project.getId() == null) {
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }

            if (project.getId() != null) {
                project.setBacklog(
                        backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }

            return projectRepository.save(project);

        } catch (Exception e) {
            throw new ProjectIdException(
                    "Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
        }

    }

    public Project findProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project ID: " + projectId.toUpperCase() + " does not exist");
        }
        return project;
    }

    public Iterable<Project> findAllProject() {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String identifier) {
        Project project = projectRepository.findByProjectIdentifier(identifier.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Can't delete project ID '" + identifier + "'");
        }
        projectRepository.delete(project);
    }
}

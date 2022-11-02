package com.shangchenhsieh.udemyCoursePPMT.services;

import com.shangchenhsieh.udemyCoursePPMT.domain.Project;
import com.shangchenhsieh.udemyCoursePPMT.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        //Logics

        return projectRepository.save(project);
    }
}

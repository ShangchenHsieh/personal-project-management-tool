package com.shangchenhsieh.udemyCoursePPMT.services;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangchenhsieh.udemyCoursePPMT.domain.Backlog;
import com.shangchenhsieh.udemyCoursePPMT.domain.ProjectTask;
import com.shangchenhsieh.udemyCoursePPMT.exceptions.ProjectIdException;
import com.shangchenhsieh.udemyCoursePPMT.repositories.BacklogRepository;
import com.shangchenhsieh.udemyCoursePPMT.repositories.ProjectRepository;
import com.shangchenhsieh.udemyCoursePPMT.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {
    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        // Exceptions: project not found
        // PTs to be added to a specific project, project != null, BL exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        // set the BL to PT
        projectTask.setBacklog(backlog);
        Integer backlogSequence = backlog.getPTSequence();
        backlogSequence++;

        backlog.setPTSequence(backlogSequence);

        // add sequence to PT
        projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);
        // initial status and priority of project to null
        if (projectTask.getPriority() == 0) {
            projectTask.setPriority(3);
        }

        if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findBacklogById(String id) {
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }

}

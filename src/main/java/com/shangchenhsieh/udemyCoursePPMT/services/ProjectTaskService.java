package com.shangchenhsieh.udemyCoursePPMT.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.shangchenhsieh.udemyCoursePPMT.domain.Backlog;
import com.shangchenhsieh.udemyCoursePPMT.domain.Project;
import com.shangchenhsieh.udemyCoursePPMT.domain.ProjectTask;
import com.shangchenhsieh.udemyCoursePPMT.exceptions.ProjectNotFoundException;
import com.shangchenhsieh.udemyCoursePPMT.repositories.BacklogRepository;
import com.shangchenhsieh.udemyCoursePPMT.repositories.ProjectRepository;
import com.shangchenhsieh.udemyCoursePPMT.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {
    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {

        try {
            // PTs to be added to a specific project, project != null, BL exists
            Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
            // set the bl to pt
            projectTask.setBacklog(backlog);
            // we want our project sequence to be like this: IDPRO-1 IDPRO-2 ...100 101
            Integer BacklogSequence = backlog.getPTSequence();
            // Update the BL SEQUENCE
            BacklogSequence++;

            backlog.setPTSequence(BacklogSequence);

            // Add Sequence to Project Task
            projectTask.setProjectSequence(backlog.getProjectIdentifier() + "-" + BacklogSequence);
            projectTask.setProjectIdentifier(projectIdentifier);

            // INITIAL priority when priority null

            // INITIAL status when status is null
            if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
                projectTask.setStatus("TO_DO");
            }

            if (projectTask.getPriority() == 0) { // In the future we need projectTask.getPriority()== 0 to handle the
                                                  // form
                projectTask.setPriority(3);
            }

            return projectTaskRepository.save(projectTask);
        } catch (Exception e) {
            throw new ProjectNotFoundException("Project not Found");
        }

    }

    public Iterable<ProjectTask> findBacklogById(String id) {

        Project project = projectRepository.findByProjectIdentifier(id);
        if (project == null) {
            throw new ProjectNotFoundException("Project with id " + id + " doesn't exist");
        }

        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }

    public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id) {
        // make sure we're searching on an existing backog
        Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
        if (backlog == null) {
            throw new ProjectNotFoundException("Project with id: " + backlog_id + " doesn't exist");
        }
        // make sure that our task exist
        ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
        if (projectTask == null) {
            throw new ProjectNotFoundException("Project task with id: " + pt_id + " doesn't exist");
        }
        // make sure that the backlog/project id in the path correspond to the right
        // project

        if (!projectTask.getProjectIdentifier().equals(backlog_id)) {
            throw new ProjectNotFoundException(
                    "Project task with id " + pt_id + " doesn't exist in project " + backlog_id);
        }
        return projectTaskRepository.findByProjectSequence(pt_id);
    }

    // update project task
    public ProjectTask updateByProjectSequence(ProjectTask updateTask, String backlog_id, String pt_id) {

        ProjectTask projectTask = findPTByProjectSequence(backlog_id, pt_id);
        projectTask = updateTask;
        return projectTaskRepository.save(projectTask);

    }

    public void deletePTByProjectSequence(String backlog_id, String pt_id) {
        ProjectTask projectTask = findPTByProjectSequence(backlog_id, pt_id);

        projectTaskRepository.delete(projectTask);
    }
}

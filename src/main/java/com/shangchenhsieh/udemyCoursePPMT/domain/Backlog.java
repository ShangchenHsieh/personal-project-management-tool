package com.shangchenhsieh.udemyCoursePPMT.domain;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Backlog")
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int PTSequence = 0;
    private String projectIdentifier;

    // 1 to 1 realtionship, which means 1 project has 1 backlog,and 1 backlog
    // belongs to 1 project
    // 1 to many relationship: 1 project has many tasks
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", nullable = false)
    @JsonIgnore
    private Project project;
    // the name of this variable should be exactly the same as the mappedBy inside
    // Project.java

    // OneToMany ProjectTask
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, mappedBy = "backlog", orphanRemoval = true) // orphanRemoval:
    private List<ProjectTask> projectTasks = new ArrayList<>();

    public Backlog() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPTSequence() {
        return this.PTSequence;
    }

    public void setPTSequence(int PTSequence) {
        this.PTSequence = PTSequence;
    }

    public String getProjectIdentifier() {
        return this.projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<ProjectTask> getProjectTasks() {
        return this.projectTasks;
    }

    public void setProjectTasks(List<ProjectTask> projectTasks) {
        this.projectTasks = projectTasks;
    }
}

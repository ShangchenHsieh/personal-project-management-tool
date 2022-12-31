package com.shangchenhsieh.udemyCoursePPMT.exceptions;

public class ProjectNotFoundExceptionResponse {

    private String projectNotFound;

    public ProjectNotFoundExceptionResponse(String ProjectNotFound) {
        projectNotFound = ProjectNotFound;
    }

    public String getProjectNotFound() {
        return this.projectNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        this.projectNotFound = projectNotFound;
    }
}
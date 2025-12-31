package com.cm.admirable.dto;

public record ProjectResponce(Integer pid, String projectName, String description ) {

    public ProjectResponce(String project_created_successfully) {
        this(1, project_created_successfully, "Appliaction Development");
    }
}

package com.cm.admirable.controller;

import com.cm.admirable.dto.ProjectRequestDto;
import com.cm.admirable.dto.ProjectResponce;
import com.cm.admirable.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectsControllor {
    private ProjectsService projectsService;

    @Autowired
    public ProjectsControllor(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

       @PostMapping("/createproject")
        public ProjectResponce CreateProjects(@RequestBody ProjectRequestDto projectrequestDto){
        return projectsService.createProjects(projectrequestDto);
        }

}

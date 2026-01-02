package com.cm.admirable.service;

import com.cm.admirable.dao.ProjectsDAO;
import com.cm.admirable.dto.ProjectRequestDto;
import com.cm.admirable.dto.ProjectResponce;
import com.cm.admirable.dto.RegisterResponse;
import com.cm.admirable.entity.Projects;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProjectsService {
private ProjectsDAO projectsDAO;
private ProjectsService projectsService;

    public ProjectsService(ProjectsDAO projectsDAO) {
        this.projectsDAO = projectsDAO;
    }

    public ProjectResponce createProjects(ProjectRequestDto projectRequestDto) {
//        AtomicReference<RegisterResponse> createProjectRes = new AtomicReference<>();
        System.out.println("Creating Project Service Called");
        Projects project = new Projects();
        System.out.println("Project Name = " + projectRequestDto.projectName());
        project.setProjectName(projectRequestDto.projectName());
        project.setClientId(projectRequestDto.clientId());
        System.out.println("Client ID = " + projectRequestDto.clientId());
        project.setStartDate(projectRequestDto.startDate());
        project.setEndDatePlan(projectRequestDto.endDatePlan());
        project.setEndDateActual(projectRequestDto.endDateActual());
        project.setStatus(projectRequestDto.status());
        project.setProjectManagerID(projectRequestDto.projectManagerID());
        project.setProjectAddress(projectRequestDto.projectAddress());
        project.setCity(projectRequestDto.city());
        project.setState(projectRequestDto.state());
        project.setZipCode(projectRequestDto.zipCode());
        project.setDescription(projectRequestDto.description());
        System.out.println("Budget Allocated = " + projectRequestDto.budgetAllocated());
        Projects saved= projectsDAO.save(project);
        System.out.println("Saved Project ID = " + saved);
        return new ProjectResponce("Project Created Successfully");

    }
}

package com.cm.admirable.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;


public record ProjectRequestDto(int pid, String projectName, int clientId, LocalDate startDate, LocalDate endDatePlan, LocalDate endDateActual, String status, double budgetAllocated, int projectManagerID, String projectAddress, String city, String state, String zipCode, String description){

    public ProjectRequestDto() {
        this(0,"",0, LocalDate.from(LocalDateTime.now()),null,null,"",0.0,0,"","","","","");
    }
}

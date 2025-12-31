package com.cm.admirable.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
@Setter
@Getter
@ToString
public class Projects {
    @Id
//    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    private Integer pid;
    @Column(name = "project_name",length = 20,nullable = false)
    private String projectName;
    @Column(name = "client_id",length = 20,nullable = false)
    private int clientId;
    @Column(name = "start_date", length = 22,nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date_plan")
    private LocalDate endDatePlan;
    @Column(name = "end_date_actual")
    private LocalDate endDateActual;
    @Column(name = "status")
    private String status;
    @Column(name = "budget_allocated",length = 20)
    private Double budgetAllocated;
    @Column(name = "projectmanager_id",length = 7)
    private int projectManagerID;
    @Column(name = "project_address",length = 50)
    private String projectAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code",length = 10)
    private String zipCode;
    @Column(name = "description",length=100,columnDefinition="TEXT")
    private String description;
}

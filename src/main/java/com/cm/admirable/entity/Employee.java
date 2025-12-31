package com.cm.admirable.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "employee_id")
 private Integer id;
 @Column(name = "first_name", nullable = false)
 private String firstName;
 @Column(name = "last_name", nullable = false)
 private String lastName;
 @Column(name = "role")
 private String role;
 @Column(name = "contact_email", nullable = false, unique = true)
 private String contactEmail;
 @Column(name = "contact_phone")
 private String contactPhone;
 @Column(name = "address")
 private String address;
 @Column(name = "date_of_hire", nullable = false)
 private String dateOfHire;
 @Column(name = "salary_rate",precision =12)
 private Double salary;
 @Column(name = "is_active")
 private Boolean activeStatus;
 @Column(name = "emergency_contact_name")
 private String emergencyContactName;
@Column(name = "emergency_contact_phone")
 private Integer emergencyContactPhone;
}

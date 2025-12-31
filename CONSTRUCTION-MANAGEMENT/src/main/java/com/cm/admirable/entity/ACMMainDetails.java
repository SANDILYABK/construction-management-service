package com.cm.admirable.entity;

import jakarta.persistence.*;
import lombok.*;

/*
*
*  */
@Entity
@ToString
@Getter
@Setter
@Table(name = "acmmaindetails")
public class ACMMainDetails {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id")
    private Long id;
    @Column(name = "companydetails")
    private String companydetails;
    @Column(name = "achivements")
    private String achivements;

}

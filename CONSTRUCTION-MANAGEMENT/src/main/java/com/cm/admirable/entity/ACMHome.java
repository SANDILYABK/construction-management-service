package com.cm.admirable.entity;
/*
 *
 *  */
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Data
@ToString
@Table(name = "acmlogin")
public class ACMHome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login_name", nullable = false, unique = true, length = 50)
    private String loginName;
    @Column(name = "login_password",nullable = false, length = 64)
    private String loginPassword;

}

package com.cm.admirable.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", length = 7)
    private Long id;
    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(unique = true, nullable = false, name = "email")
    private String email;

    @Column(name = "phone",length =10)
    private String phone;

    @Column(name = "password_hash", length = 12)
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;     // ACTIVE, INACTIVE, BLOCKED

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;
    public enum Status {
        ACTIVE, INACTIVE, BLOCKED
    }
}

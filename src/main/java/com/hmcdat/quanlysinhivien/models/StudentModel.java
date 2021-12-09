package com.hmcdat.quanlysinhivien.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "students")
public class StudentModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "class_id")
    private long classId;

    @Column(name = "department_id")
    private long departmentId;

}

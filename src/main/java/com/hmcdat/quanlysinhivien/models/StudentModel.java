package com.hmcdat.quanlysinhivien.models;

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
    private int classId;

    @Column(name = "department_id")
    private int departmentId;

}

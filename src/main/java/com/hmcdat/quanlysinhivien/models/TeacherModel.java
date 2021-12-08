package com.hmcdat.quanlysinhivien.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class TeacherModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "address")
    private String address;

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
}

package com.hmcdat.quanlysinhivien.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "departments")
@Data
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "department_id")
    private int departmentId;
}

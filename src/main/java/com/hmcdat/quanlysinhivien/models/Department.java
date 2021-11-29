package com.hmcdat.quanlysinhivien.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "departments")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "vice_manager_id")
    private int viceManagerId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;
}

package com.hmcdat.quanlysinhivien.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class DepartmentModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private long managerId;

    @Column(name = "vice_manager_id")
    private long viceManagerId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

}

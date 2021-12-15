package com.hmcdat.quanlysinhivien.dto;

import com.hmcdat.quanlysinhivien.models.ClassModel;
import com.hmcdat.quanlysinhivien.models.StudentModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassDto {
    private long id;
    private String name;
    private String department;
    private String manager;
    private List<StudentModel> students;
}

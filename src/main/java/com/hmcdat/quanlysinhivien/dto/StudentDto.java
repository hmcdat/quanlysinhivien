package com.hmcdat.quanlysinhivien.dto;

import com.hmcdat.quanlysinhivien.models.ScoreModel;
import com.hmcdat.quanlysinhivien.models.StudentModel;
import com.hmcdat.quanlysinhivien.repositories.ScoreRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StudentDto {
    private long id;
    private String fullName;
    private boolean gender;
    private String dob;
    private String email;
    private String phone;
    private long classId;
    private long departmentId;
    private List<ScoreDto> scores;

    public StudentDto(StudentModel student) {
        this.id = student.getId();
        this.fullName = student.getFullName();
        this.gender = student.isGender();
        this.dob = student.getDob();
        this.email = student.getEmail();
        this.phone = student.getPhone();
        this.classId = student.getClassId();
        this.departmentId = student.getDepartmentId();
    }
}


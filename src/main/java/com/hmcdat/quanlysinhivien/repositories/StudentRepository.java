package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    StudentModel findById(long id);
    List<StudentModel> findAllByClassId(long classId);
}

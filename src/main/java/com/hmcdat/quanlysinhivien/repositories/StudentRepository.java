package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    StudentModel findById(long id);
}

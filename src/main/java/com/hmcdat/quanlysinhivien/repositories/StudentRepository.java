package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentModel, Long> {
    StudentModel findById(long id);
    List<StudentModel> findAllByClassId(long classId);
}

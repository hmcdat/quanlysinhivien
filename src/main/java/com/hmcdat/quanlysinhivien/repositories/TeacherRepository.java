package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
    TeacherModel getById(long id);
}

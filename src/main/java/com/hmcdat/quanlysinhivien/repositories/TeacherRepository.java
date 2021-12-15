package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<TeacherModel, Long> {
    TeacherModel findById(long id);
}

package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassModel, Long> {
    ClassModel findById(long id);
}
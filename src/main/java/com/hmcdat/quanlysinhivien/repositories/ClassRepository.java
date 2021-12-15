package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends CrudRepository<ClassModel, Long> {
    ClassModel findById(long id);
    ClassModel findByName(String name);
}

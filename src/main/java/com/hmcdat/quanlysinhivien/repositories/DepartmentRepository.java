package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
    DepartmentModel getById(long id);
}

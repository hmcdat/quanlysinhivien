package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
    DepartmentModel findById(long id);
    DepartmentModel findByManagerId(long managerId);
    DepartmentModel findByViceManagerId(long viceManagerId);
}

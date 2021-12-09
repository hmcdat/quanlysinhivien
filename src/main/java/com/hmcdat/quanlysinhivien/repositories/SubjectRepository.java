package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectModel, Long> {
    SubjectModel findById(long id);
}

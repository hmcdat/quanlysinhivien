package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.models.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<SubjectModel, Long> {
    SubjectModel findById(long id);
}

package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.dto.ScoreDto;
import com.hmcdat.quanlysinhivien.models.ScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScoreRepository extends CrudRepository<ScoreModel, Long> {
    ScoreModel findById(long id);
    ScoreModel findByStudentIdAndSubjectIdAndSemester(long studentId, long subjectId, int semester);
    List<ScoreModel> findAllByStudentId(long studentId);
}

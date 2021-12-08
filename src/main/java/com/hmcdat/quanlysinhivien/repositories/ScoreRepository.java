package com.hmcdat.quanlysinhivien.repositories;

import com.hmcdat.quanlysinhivien.dto.ScoreDto;
import com.hmcdat.quanlysinhivien.models.ScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreModel, Long> {
    ScoreModel findByStudentIdAndSubjectIdAndSemester(long studentId, long subjectId, int semester);
    List<ScoreModel> findAllByStudentId(long studentId);
}

package com.hmcdat.quanlysinhivien.controllers;

import com.hmcdat.quanlysinhivien.dto.ScoreDto;
import com.hmcdat.quanlysinhivien.dto.StudentDto;
import com.hmcdat.quanlysinhivien.models.ScoreModel;
import com.hmcdat.quanlysinhivien.models.StudentModel;
import com.hmcdat.quanlysinhivien.repositories.ScoreRepository;
import com.hmcdat.quanlysinhivien.repositories.StudentRepository;
import com.hmcdat.quanlysinhivien.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController  {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ScoreRepository scoreRepository;

    @GetMapping("")
    public ResponseEntity<Object> getAllStudents() {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, studentRepository.findAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createNewStudent(@RequestBody StudentModel data) {
        try {
            StudentModel student = studentRepository.save(data);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, student);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> getStudent(@PathVariable long id) {
        try {
            StudentModel student = studentRepository.findById(id);
            if (student != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, student);
            } else {
                return ResponseHandler.generateResponse("Not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> edit(@PathVariable long id, @RequestBody StudentModel data) {
        try {
            StudentModel student = studentRepository.findById(id);
            student.setClassId(data.getClassId());
            student.setDepartmentId(data.getDepartmentId());
            student.setDob(data.getDob());
            student.setDob(data.getDob());
            student.setEmail(data.getEmail());
            student.setFullName(data.getFullName());
            student.setPhone(data.getPhone());
            studentRepository.save(student);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, student);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/{id}/addScore")
    public ResponseEntity<Object> addScore(@PathVariable long id, @RequestBody ScoreDto data) {
        StudentModel student = studentRepository.findById(id);
        if (student == null)
            return ResponseHandler.generateResponse("Student not found", HttpStatus.NOT_FOUND, null);
        ScoreModel findScore = scoreRepository.findByStudentIdAndSubjectIdAndSemester(student.getId(), data.getSubjectId(), data.getSemester());
        if (findScore == null) {
            ScoreModel score = new ScoreModel();
            score.setStudentId(student.getId());
            score.setClassId(student.getClassId());
            score.setDepartmentId(student.getDepartmentId());
            score.setSemester(data.getSemester());
            score.setSubjectId(data.getSubjectId());
            score.setFirstScore(data.getFirstScore());
            score.setLastScore(data.getLastScore());
            scoreRepository.save(score);

            StudentDto stDto = new StudentDto(student);
            List<ScoreDto> scores = (List<ScoreDto>)(Object)scoreRepository.findAllByStudentId(student.getId());
            stDto.setScores(scores);

            return ResponseHandler.generateResponse("Success", HttpStatus.OK, stDto);
        } else {
            return ResponseHandler.generateResponse("Exist!", HttpStatus.BAD_REQUEST, null);
        }
    }

    @PostMapping("/{id}/editScore")
    public ResponseEntity<Object> editScore(@PathVariable long id, @RequestBody ScoreDto data) {
        //StudentModel student
        return new ResponseEntity<Object>(null);
    }
}

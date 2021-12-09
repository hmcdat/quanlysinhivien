package com.hmcdat.quanlysinhivien.controllers;

import com.hmcdat.quanlysinhivien.dto.ClassForStudents;
import com.hmcdat.quanlysinhivien.models.ClassModel;
import com.hmcdat.quanlysinhivien.models.StudentModel;
import com.hmcdat.quanlysinhivien.repositories.*;
import com.hmcdat.quanlysinhivien.responses.ResponseHandler;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utils")
public class UtilsController {
    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectController subjectController;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ClassRepository classRepository;

    @GetMapping("/getAllStudentsByClassName")
    public ResponseEntity<Object> getAllStudentsByClassName(@RequestParam(value = "className") String className) {
        ClassModel findClass = classRepository.findByName(className);
        if (findClass == null) {
            return ResponseHandler.generateResponse("Class not found", HttpStatus.OK, null);
        }
        List<StudentModel> students = studentRepository.findAllByClassId(findClass.getId());
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, students);
    }

    @PostMapping("/setClassForStudents")
    public ResponseEntity<Object> setClassforStudents(@RequestBody ClassForStudents data) {
        return new ResponseEntity<>(null);
    }
}

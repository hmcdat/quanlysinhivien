package com.hmcdat.quanlysinhivien.controllers;

import com.hmcdat.quanlysinhivien.models.TeacherModel;
import com.hmcdat.quanlysinhivien.repositories.TeacherRepository;
import com.hmcdat.quanlysinhivien.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("")
    public ResponseEntity<Object> getAllTeachers() {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, teacherRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTeacher(@PathVariable long id) {
        TeacherModel teacher = teacherRepository.findById(id);
        if (teacher == null) {
            return ResponseHandler.generateResponse("Teacher not found", HttpStatus.NOT_FOUND, null);
        }

        return ResponseHandler.generateResponse("Success", HttpStatus.NOT_FOUND, teacher);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createNewTeacher(@RequestBody TeacherModel data) {
        try {
            TeacherModel teacher = new TeacherModel();
            teacher.setEmail(data.getEmail());
            teacher.setPhone(data.getPhone());
            teacher.setGender(data.isGender());
            teacher.setFullName(data.getFullName());
            teacher.setAddress(data.getAddress());
            teacher.setDepartmentId(data.getDepartmentId());
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, teacherRepository.save(teacher));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad request", HttpStatus.OK, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editTeacher(@PathVariable long id, @RequestBody TeacherModel data) {
        try {
            TeacherModel teacher = teacherRepository.findById(id);
            if (teacher == null) {
                return ResponseHandler.generateResponse("Teacher not found", HttpStatus.NOT_FOUND, null);
            }
            teacher.setFullName(data.getFullName());
            teacher.setPhone(data.getPhone());
            teacher.setGender(data.isGender());
            teacher.setEmail(data.getEmail());
            teacher.setDepartmentId(data.getDepartmentId());
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, teacherRepository.save(teacher));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
        }
    }
}

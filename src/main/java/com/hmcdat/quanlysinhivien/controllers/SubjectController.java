package com.hmcdat.quanlysinhivien.controllers;

import com.hmcdat.quanlysinhivien.models.SubjectModel;
import com.hmcdat.quanlysinhivien.repositories.SubjectRepository;
import com.hmcdat.quanlysinhivien.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("")
    public ResponseEntity<Object> getAllSubjects() {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, subjectRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSubjectInfo(@PathVariable long id) {
        SubjectModel subject = subjectRepository.findById(id);
        if (subject == null) {
            return ResponseHandler.generateResponse("Subject not found", HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, subject);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createNewSubject(@RequestBody SubjectModel data) {
        SubjectModel subject = new SubjectModel();
        subject.setName(data.getName());
        subject.setType(data.getType());
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, subjectRepository.save(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editSubject(@PathVariable long id, @RequestBody SubjectModel data) {
        SubjectModel subject = subjectRepository.findById(id);
        if (subject == null) {
            return ResponseHandler.generateResponse("Subject not found", HttpStatus.NOT_FOUND, null);
        }
        subject.setType(data.getType());
        subject.setName(data.getName());
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, subjectRepository.save(subject));
    }
}

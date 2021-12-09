package com.hmcdat.quanlysinhivien.controllers;

import com.hmcdat.quanlysinhivien.models.ClassModel;
import com.hmcdat.quanlysinhivien.repositories.ClassRepository;
import com.hmcdat.quanlysinhivien.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("classes")
public class ClassController {
    @Autowired
    private ClassRepository classRepository;

    @GetMapping("")
    public ResponseEntity<Object> getAllClass() {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, classRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClass(@PathVariable long id) {
        try {
            ClassModel findClassModel = classRepository.findById(id);
            if (findClassModel != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, findClassModel);
            } else {
                return ResponseHandler.generateResponse("Not found", HttpStatus.NOT_FOUND, null);
            }
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createNewClass(@RequestBody ClassModel newClassModel) {
        try {
            ClassModel findClass = classRepository.findByName(newClassModel.getName());
            if (findClass != null) {
                return ResponseHandler.generateResponse("Class exist", HttpStatus.BAD_REQUEST, null);
            }
            ClassModel newClass = new ClassModel();
            newClass.setName(newClassModel.getName());
            newClass.setDepartmentId(newClassModel.getDepartmentId());
            newClass.setManagerId(newClassModel.getManagerId());
            ClassModel returnClassModel = classRepository.save(newClassModel);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, returnClassModel);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> editClass(@PathVariable long id, @RequestBody ClassModel data) {
        try {
            ClassModel findClassModel = classRepository.findById(id);
            ClassModel findClassName = classRepository.findByName(data.getName());
//            System.out.println(data.getName());

            if (findClassName != null && !findClassModel.getName().equals(findClassName.getName())) {
                return ResponseHandler.generateResponse("This class name exist!", HttpStatus.BAD_REQUEST, null);
            }

            findClassModel.setName(data.getName());
            findClassModel.setDepartmentId(data.getDepartmentId());
            findClassModel.setManagerId(data.getManagerId());
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, classRepository.save(findClassModel));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
        }
    }
}

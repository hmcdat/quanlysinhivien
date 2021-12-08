package com.hmcdat.quanlysinhivien.controllers;

import com.hmcdat.quanlysinhivien.models.DepartmentModel;
import com.hmcdat.quanlysinhivien.models.TeacherModel;
import com.hmcdat.quanlysinhivien.repositories.DepartmentRepository;
import com.hmcdat.quanlysinhivien.repositories.TeacherRepository;
import com.hmcdat.quanlysinhivien.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("")
    public ResponseEntity<Object> getAllDepartments() {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, departmentRepository.findAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createNewDepartment(@RequestBody DepartmentModel departmentModel) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, departmentRepository.save(departmentModel));

        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDepartment(@PathVariable long id) {
        DepartmentModel department = departmentRepository.getById(id);
        if (department != null) {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, department);
        } else {
            return ResponseHandler.generateResponse("Not found", HttpStatus.NOT_FOUND, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editDepartment(@PathVariable long id, DepartmentModel data) {
        try {
            DepartmentModel department = departmentRepository.getById(id);
            if (department != null) {
                department.setPhone(data.getPhone());
                department.setAddress(data.getAddress());
                department.setName(data.getName());
                return ResponseHandler.generateResponse("Success", HttpStatus.NOT_FOUND, departmentRepository.save(department));
            } else {
                return ResponseHandler.generateResponse("Not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad reqeust", HttpStatus.BAD_REQUEST, null);
        }
    }

    @PostMapping("/{id}/changeManager")
    public ResponseEntity<Object> changeManager(
            @PathVariable long id,
            @RequestParam(value = "managerId", required = false) long managerId
    ) {
        try {
            DepartmentModel department = departmentRepository.getById(id);
            if (department == null) {
                return ResponseHandler.generateResponse("Department not found", HttpStatus.NOT_FOUND, null);
            }
            TeacherModel teacher = teacherRepository.getById(managerId);
            if (teacher == null) {
                return ResponseHandler.generateResponse("Manager not found", HttpStatus.NOT_FOUND, null);
            }
            department.setManagerId(teacher.getId());
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, departmentRepository.save(department));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad Request", HttpStatus.BAD_REQUEST, null);
        }
    }


    @PostMapping("/{id}/changeViceManager")
    public ResponseEntity<Object> changeViceManager(
            @PathVariable long id,
            @RequestParam(value = "viceManagerId", required = false) long viceManagerId
    ) {
        try {
            DepartmentModel department = departmentRepository.getById(id);
            if (department == null) {
                return ResponseHandler.generateResponse("Department not found", HttpStatus.NOT_FOUND, null);
            }
            TeacherModel teacher = teacherRepository.getById(viceManagerId);
            if (teacher == null) {
                return ResponseHandler.generateResponse("Manager not found", HttpStatus.NOT_FOUND, null);
            }
            department.setViceManagerId(teacher.getId());
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, departmentRepository.save(department));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad Request", HttpStatus.BAD_REQUEST, null);
        }
    }
}

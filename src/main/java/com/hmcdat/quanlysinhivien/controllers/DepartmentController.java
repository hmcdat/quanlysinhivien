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
@RequestMapping("/departments")
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
            if (departmentRepository.findByManagerId(departmentModel.getManagerId()) != null) {
                return ResponseHandler.generateResponse("This teacher is a manager of another department", HttpStatus.BAD_REQUEST, null);
            }

            if (departmentRepository.findByViceManagerId(departmentModel.getViceManagerId()) != null) {
                return ResponseHandler.generateResponse("This teacher is a vice manager of another department", HttpStatus.BAD_REQUEST, null);
            }
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, departmentRepository.save(departmentModel));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDepartment(@PathVariable long id) {
        DepartmentModel department = departmentRepository.findById(id);
        if (department == null) {
            return ResponseHandler.generateResponse("Not found", HttpStatus.NOT_FOUND, null);
        } else {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, department);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editDepartment(@PathVariable long id, @RequestBody DepartmentModel data) {
        try {
            DepartmentModel department = departmentRepository.getById(id);
            if (department != null) {
                department.setName(data.getName());
                department.setPhone(data.getPhone());
                department.setAddress(data.getAddress());
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, departmentRepository.save(department));
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
            @RequestBody DepartmentModel data
    ) {
        try {
            if (data.getManagerId() == 0) {
                return ResponseHandler.generateResponse("Require managerId", HttpStatus.BAD_REQUEST, null);
            }
            DepartmentModel department = departmentRepository.getById(id);
            if (department == null) {
                return ResponseHandler.generateResponse("Department not found", HttpStatus.NOT_FOUND, null);
            }
            TeacherModel teacher = teacherRepository.getById(data.getManagerId());
            if (teacher == null) {
                return ResponseHandler.generateResponse("Manager not found", HttpStatus.NOT_FOUND, null);
            }

            if (departmentRepository.findByManagerId(data.getManagerId()) != null) {
                return ResponseHandler.generateResponse("This teacher is a manager of another department", HttpStatus.BAD_REQUEST, null);
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
           @RequestBody DepartmentModel data
    ) {
        try {
            if (data.getViceManagerId() == 0) {
                return ResponseHandler.generateResponse("Require viceManagerId", HttpStatus.BAD_REQUEST, null);
            }
            DepartmentModel department = departmentRepository.getById(id);
            if (department == null) {
                return ResponseHandler.generateResponse("Department not found", HttpStatus.NOT_FOUND, null);
            }
            TeacherModel teacher = teacherRepository.getById(data.getViceManagerId());
            if (teacher == null) {
                return ResponseHandler.generateResponse("Manager not found", HttpStatus.NOT_FOUND, null);
            }

            if (departmentRepository.findByViceManagerId(data.getViceManagerId()) != null) {
                return ResponseHandler.generateResponse("This teacher is a vice manager of another department", HttpStatus.BAD_REQUEST, null);
            }
            department.setViceManagerId(teacher.getId());
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, departmentRepository.save(department));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad Request", HttpStatus.BAD_REQUEST, null);
        }
    }
}

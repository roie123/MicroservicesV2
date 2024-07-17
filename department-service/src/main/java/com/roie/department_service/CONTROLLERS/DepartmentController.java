package com.roie.department_service.CONTROLLERS;

import com.roie.department_service.ENTITY.Department;
import com.roie.department_service.REPOSITORIES.DepartmentRepository;
import com.roie.department_service.client.EmployeeClient;
import jakarta.ws.rs.GET;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        log.info("Department addDepartment: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        log.info("Department findAll");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        log.info("Department findById: id={}", id);
        return departmentRepository.findById(id);
    }


    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        log.info("Department findAll");
        List<Department> departmentList= departmentRepository.findAll();

        departmentList.forEach(department -> {
            department.setEmployees(employeeClient.findByDepartment(department.getId()));
        });
    return departmentList;

    }









}

package com.roie.department_service.client;

import com.roie.department_service.ENTITY.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.invoker.ReactorHttpExchangeAdapter;

import java.util.List;

@HttpExchange
public interface  EmployeeClient{
    @GetExchange("/employee/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) ;

    }

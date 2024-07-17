package com.roie.department_service.ENTITY;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Department {
    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();



    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }


    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
public Department(){

}




}

package com.Anoshor.EmployeeCrudDemo.service;

import com.Anoshor.EmployeeCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee emp);
    void deleteById(int id);
}

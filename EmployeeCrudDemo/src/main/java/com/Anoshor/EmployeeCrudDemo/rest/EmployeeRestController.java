package com.Anoshor.EmployeeCrudDemo.rest;

import com.Anoshor.EmployeeCrudDemo.dao.EmployeeDAO;
import com.Anoshor.EmployeeCrudDemo.entity.Employee;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO edao;
    public EmployeeRestController(EmployeeDAO edao) {
        this.edao = edao;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return edao.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee emp = edao.findById(employeeId);
        if(emp == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        emp.setId(0);
        return edao.save(emp);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp) {
        return edao.save(emp);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee emp = edao.findById(employeeId);
        if(emp == null) {
            throw new RuntimeException("Employee id not found");
        }
        edao.deleteById(employeeId);
        System.out.println("Employee deleted");
    }

}

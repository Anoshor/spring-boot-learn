package com.Anoshor.EmployeeCrudDemo.service;

import com.Anoshor.EmployeeCrudDemo.dao.EmployeeDAO;
import com.Anoshor.EmployeeCrudDemo.entity.Employee;
import jakarta.transaction.Transactional;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO edao;
    @Override
    public List<Employee> findAll() {
        return edao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return edao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee emp) {
        return edao.save(emp);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        edao.deleteById(id);
    }
}

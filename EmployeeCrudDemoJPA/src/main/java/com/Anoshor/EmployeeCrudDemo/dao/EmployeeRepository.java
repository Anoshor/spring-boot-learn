package com.Anoshor.EmployeeCrudDemo.dao;

import com.Anoshor.EmployeeCrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

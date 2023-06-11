package com.employee.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.net.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

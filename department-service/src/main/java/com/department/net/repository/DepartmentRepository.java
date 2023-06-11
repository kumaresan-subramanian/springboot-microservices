package com.department.net.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department.net.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByCode(String code);
}

package com.department.net.service;

import com.department.net.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto department);
	
	DepartmentDto getDepartmentByCode(String code);
}

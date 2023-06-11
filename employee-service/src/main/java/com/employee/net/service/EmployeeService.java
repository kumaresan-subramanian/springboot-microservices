package com.employee.net.service;

import com.employee.net.Dto.ApiResponseDto;
import com.employee.net.Dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employee);
	
	ApiResponseDto findEmployeeById(Long id);
}

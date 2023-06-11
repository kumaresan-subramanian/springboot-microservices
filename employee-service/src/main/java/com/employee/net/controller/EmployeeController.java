package com.employee.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.net.Dto.ApiResponseDto;
import com.employee.net.Dto.EmployeeDto;
import com.employee.net.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee){
		
		EmployeeDto emplyeedb = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(emplyeedb, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> geEmployeeById(@PathVariable Long id){
		
		ApiResponseDto emplyeedb = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(emplyeedb, HttpStatus.OK);
	}
	
}

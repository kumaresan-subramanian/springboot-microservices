package com.department.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.net.dto.DepartmentDto;
import com.department.net.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto department){
		
		DepartmentDto saveDepartment = departmentService.saveDepartment(department);
		
		return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("{code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code){
		
		DepartmentDto department = departmentService.getDepartmentByCode(code);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
}

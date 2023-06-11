package com.department.net.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.net.dto.DepartmentDto;
import com.department.net.entity.Department;
import com.department.net.repository.DepartmentRepository;
import com.department.net.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto department) {
		
		Department departdb = departmentRepo.save(modelMapper.map(department, Department.class));
		return modelMapper.map(departdb, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		
		Department departdb = departmentRepo.findByCode(code);
		return modelMapper.map(departdb, DepartmentDto.class);
	}

	
}

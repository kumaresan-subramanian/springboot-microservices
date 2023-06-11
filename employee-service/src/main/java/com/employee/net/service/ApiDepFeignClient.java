package com.employee.net.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.net.Dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiDepFeignClient {

	@GetMapping("api/departments/{code}")
	public DepartmentDto getDepartmentByCode(@PathVariable String code);
}

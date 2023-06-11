package com.employee.net.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.net.Dto.DepartmentDto;
import com.employee.net.Dto.OrganizationDto;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface ApiOrgFeignClient {

	@GetMapping("api/organizations/{code}")
	public OrganizationDto getOrganizationByCode(@PathVariable String code);
}

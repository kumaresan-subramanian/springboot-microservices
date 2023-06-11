package com.employee.net.service.impl;

import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.net.Dto.ApiResponseDto;
import com.employee.net.Dto.DepartmentDto;
import com.employee.net.Dto.EmployeeDto;
import com.employee.net.Dto.OrganizationDto;
import com.employee.net.entity.Employee;
import com.employee.net.repository.EmployeeRepository;
import com.employee.net.service.ApiDepFeignClient;
import com.employee.net.service.ApiOrgFeignClient;
import com.employee.net.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	RestTemplate restemplate;
	
	@Autowired
	WebClient webclient;
	
	@Autowired
	private ApiDepFeignClient apiDepClient;
	
	@Autowired
	private ApiOrgFeignClient apiOrgClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employee) {

		Employee employeedb = employeeRepo.save(modelMapper.map(employee, Employee.class));
		return modelMapper.map(employeedb, EmployeeDto.class);
	}

//	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto findEmployeeById(Long id) {
		LOGGER.info("inside findEmployeeById");
		Employee employeedb = employeeRepo.findById(id).get();
		
//		ResponseEntity<DepartmentDto> responseEntity = restemplate.getForEntity("http://localhost:8081/api/departments/"+employeedb.getDepartmentCode(), DepartmentDto.class);
//		DepartmentDto department = responseEntity.getBody();
		
//		DepartmentDto department = webclient.get()
//					.uri("http://localhost:8081/api/departments/"+employeedb.getDepartmentCode())
//					.retrieve()
//					.bodyToMono(DepartmentDto.class)
//					.block();
		
		DepartmentDto department = apiDepClient.getDepartmentByCode(employeedb.getDepartmentCode());
		OrganizationDto organization = apiOrgClient.getOrganizationByCode(employeedb.getOrganizationCode());
		ApiResponseDto apiResponse = new ApiResponseDto();
		apiResponse.setDepartment(department);
		apiResponse.setOrganization(organization);
		apiResponse.setEmployee(modelMapper.map(employeedb, EmployeeDto.class));
		return apiResponse;
	}
	
	public ApiResponseDto getDefaultDepartment(Long id, Exception e) {
		LOGGER.info("inside getDefaultDepartment");
		Employee employeedb = employeeRepo.findById(id).get();
		DepartmentDto department = new DepartmentDto();
		department.setCode("default");
		department.setDescription("default");
		department.setName("dafault");
		department.setId(0l);
		ApiResponseDto apiResponse = new ApiResponseDto();
		apiResponse.setDepartment(department);
		apiResponse.setEmployee(modelMapper.map(employeedb, EmployeeDto.class));
		return apiResponse;
	}

}

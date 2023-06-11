package com.employee.net.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {

	private EmployeeDto employee;
	private DepartmentDto department;
	private OrganizationDto organization;
}

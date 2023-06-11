package com.employee.net.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

	private Long id;
	private String name;
	private String description;
	private String code;
	private LocalDateTime createdDate;
}

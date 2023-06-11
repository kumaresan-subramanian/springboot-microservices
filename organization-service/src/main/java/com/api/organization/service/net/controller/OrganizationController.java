package com.api.organization.service.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.organization.service.net.Dto.OrganizationDto;
import com.api.organization.service.net.service.OrganizationService;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;
	
	@PostMapping
	public ResponseEntity<OrganizationDto> saveEmployee(@RequestBody OrganizationDto organization){
		
		OrganizationDto organizationdb = organizationService.saveOrganization(organization);
		return new ResponseEntity<>(organizationdb, HttpStatus.CREATED);
	}
	
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code){
		
		OrganizationDto organizationdb = organizationService.getOrganizationByCode(code);
		return new ResponseEntity<>(organizationdb, HttpStatus.OK);
	}
}

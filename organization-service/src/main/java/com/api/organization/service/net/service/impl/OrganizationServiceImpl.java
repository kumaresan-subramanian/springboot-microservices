package com.api.organization.service.net.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.organization.service.net.Dto.OrganizationDto;
import com.api.organization.service.net.entity.Organization;
import com.api.organization.service.net.repository.OrganizationRepository;
import com.api.organization.service.net.service.OrganizationService;
import com.netflix.discovery.converters.Auto;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	OrganizationRepository organizationRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organization) {
		Organization organizationdb = organizationRepo.save(modelMapper.map(organization, Organization.class));
		return modelMapper.map(organizationdb, OrganizationDto.class);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String code) {
		Organization organizationdb = organizationRepo.findByCode(code);
		return modelMapper.map(organizationdb, OrganizationDto.class);
	}

}

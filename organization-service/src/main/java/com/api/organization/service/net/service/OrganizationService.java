package com.api.organization.service.net.service;

import com.api.organization.service.net.Dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto saveOrganization(OrganizationDto organization);
	
	OrganizationDto getOrganizationByCode(String code);
}

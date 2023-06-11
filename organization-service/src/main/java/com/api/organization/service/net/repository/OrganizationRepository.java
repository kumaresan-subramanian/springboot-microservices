package com.api.organization.service.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.organization.service.net.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{
	
	Organization findByCode(String code);
}

package com.example.organizationservice.service;

import com.example.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationCode(String organizationCode);
}

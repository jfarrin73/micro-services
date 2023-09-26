package com.example.organizationservice.service.impl;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.repository.OrganizationRepository;
import com.example.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.organizationservice.mapper.OrganizationMapper.mapToOrganization;
import static com.example.organizationservice.mapper.OrganizationMapper.mapToOrganizationDto;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        return mapToOrganizationDto(organizationRepository.save(mapToOrganization(organizationDto)));
    }
}

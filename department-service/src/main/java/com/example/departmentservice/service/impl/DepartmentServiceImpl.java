package com.example.departmentservice.service.impl;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.departmentservice.mapper.DepartmentMapper.mapToDepartment;
import static com.example.departmentservice.mapper.DepartmentMapper.mapToDepartmentDto;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        return mapToDepartmentDto(departmentRepository.save(mapToDepartment(departmentDto)));
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        return mapToDepartmentDto(departmentRepository.findByDepartmentCode(departmentCode));
    }
}

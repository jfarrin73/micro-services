package com.example.employeeservice.service.impl;

import com.example.employeeservice.Entity.Employee;
import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.dto.OrganizationDto;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static com.example.employeeservice.mapper.EmployeeMapper.mapToEmployee;
import static com.example.employeeservice.mapper.EmployeeMapper.mapToEmployeeDto;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
    private WebClient webClient;
//    private APIClient apiClient;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return mapToEmployeeDto(employeeRepository.save(mapToEmployee(employeeDto)));
    }

    @Override
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long id) {

        logger.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(id).get();

        String departmentUri = "http://localhost:8080/api/departments/" + employee.getDepartmentCode();
        String organizationUri = "http://localhost:8083/api/organizations/" + employee.getOrganizationCode();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(departmentUri, DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient
                .get()
                .uri(departmentUri)
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganizationDto organizationDto = webClient
                .get()
                .uri(organizationUri)
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

//        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        return new APIResponseDto(mapToEmployeeDto(employee), departmentDto, organizationDto);
    }

    public APIResponseDto getDefaultDepartment(Long id, Exception exception) {

        logger.info("inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(id).get();
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        return new APIResponseDto(mapToEmployeeDto(employee), departmentDto, new OrganizationDto());
    }
}

package com.employee.portal.service.impl;

import com.employee.portal.dto.EmployeeDTO;
import com.employee.portal.repository.EmployeeRepository;
import com.employee.portal.repository.entity.EmployeeEntity;
import com.employee.portal.service.EmployeeService;
import com.employee.portal.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.save(EmployeeUtil.dtoToEntity(employeeDTO));
        return EmployeeUtil.entityToDTO(employeeEntity);
    }

    @Override
    @Transactional
    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeUtil::entityToDTO)
                .sorted((e1, e2) -> e1.getFirstName().compareToIgnoreCase(e2.getFirstName()))
                .collect(Collectors.toList());
    }
}

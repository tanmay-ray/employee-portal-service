package com.employee.portal.service;

import com.employee.portal.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getEmployees();
}

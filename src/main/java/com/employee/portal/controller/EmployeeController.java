package com.employee.portal.controller;

import com.employee.portal.dto.EmployeeDTO;
import com.employee.portal.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/employee-service")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "Register a new emploee")
    @PostMapping("employee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @ApiOperation(value = "Fetch all employees")
    @GetMapping("employees")
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getEmployees();
    }
}

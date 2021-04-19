package com.employee.portal.controller;

import com.employee.portal.dto.EmployeeDTO;
import com.employee.portal.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeService employeeService;

    @Test
    public void createEmployeeTest(){
        EmployeeDTO employee = EmployeeDTO.builder()
                .dob(LocalDate.now().minusYears(20)).department("IT")
                .firstName("John").lastName("Doe").gender("Male").build();
        when(employeeService.createEmployee(any())).thenReturn(employee);

        EmployeeDTO response = employeeController.createEmployee(employee);
        assertEquals(employee, response);
    }

    @Test
    public void getEmployeesTest(){
        List<EmployeeDTO> employees = Collections.singletonList(EmployeeDTO.builder()
                .dob(LocalDate.now().minusYears(20)).department("IT")
                .firstName("Jane").lastName("Doe").gender("Female").build());
        when(employeeService.getEmployees()).thenReturn(employees);

        List<EmployeeDTO> response = employeeController.getAllEmployee();
        assertEquals(employees, response);
    }
}

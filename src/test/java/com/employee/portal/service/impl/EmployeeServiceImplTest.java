package com.employee.portal.service.impl;


import com.employee.portal.dto.EmployeeDTO;
import com.employee.portal.repository.EmployeeRepository;
import com.employee.portal.repository.entity.EmployeeEntity;
import com.employee.portal.util.EmployeeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    public void createEmployeeTest(){
        EmployeeEntity employee = EmployeeEntity.builder()
                .dob(LocalDate.now().minusYears(20)).department("IT")
                .firstName("John").lastName("Doe").gender("Male").build();
        when(employeeRepository.save(any())).thenReturn(employee);

        EmployeeDTO response = employeeService.createEmployee(EmployeeUtil.entityToDTO(employee));
        assertEquals(employee.getFirstName(), response.getFirstName());
    }

    @Test
    public void getEmployeesTest(){
        List<EmployeeEntity> employees = Collections.singletonList(EmployeeEntity.builder()
                .dob(LocalDate.now().minusYears(20)).department("IT")
                .firstName("Jane").lastName("Doe").gender("Female").build());
        when(employeeRepository.findAllByOrderByFirstName()).thenReturn(employees.stream());

        List<EmployeeDTO> response = employeeService.getEmployees();
        assertEquals(employees.size(), response.size());
        assertEquals(employees.get(0).getFirstName(), response.get(0).getFirstName());
    }

}

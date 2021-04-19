package com.employee.portal.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String gender;
    private String department;
    private LocalDate dob;
}

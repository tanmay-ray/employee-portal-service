package com.employee.portal.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="GENDER")
    private String gender;

    @Column(name="DATE_OF_BIRTH")
    private LocalDate dob;

    @Column(name="DEPARTMENT")
    private String department;

}

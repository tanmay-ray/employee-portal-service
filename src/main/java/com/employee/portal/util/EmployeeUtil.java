package com.employee.portal.util;

import com.employee.portal.dto.EmployeeDTO;
import com.employee.portal.repository.entity.EmployeeEntity;

public class EmployeeUtil {
    private EmployeeUtil() {}

    public static EmployeeEntity dtoToEntity(EmployeeDTO dto) {
        return EmployeeEntity.builder()
                .department(dto.getDepartment())
                .dob(dto.getDob())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .gender(dto.getGender())
                .build();
    }

    public static EmployeeDTO entityToDTO(EmployeeEntity entity) {
        return EmployeeDTO.builder()
                .department(entity.getDepartment())
                .dob(entity.getDob())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender())
                .build();
    }
}

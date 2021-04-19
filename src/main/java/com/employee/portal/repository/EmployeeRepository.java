package com.employee.portal.repository;

import com.employee.portal.repository.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    Stream<EmployeeEntity> findAllByOrderByFirstName();
}

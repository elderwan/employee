package com.elderwan.employee.repository;

import com.elderwan.employee.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Long> {
    EmployeesEntity findByEmployeeId(String employeeId);

}

package com.elderwan.employee.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeesDTO {
    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
}

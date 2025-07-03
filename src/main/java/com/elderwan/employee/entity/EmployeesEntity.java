package com.elderwan.employee.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "employees")
public class EmployeesEntity {

    @Id
    @GeneratedValue(generator = "snowflake")
    @GenericGenerator(name = "snowflake", strategy = "com.elderwan.employee.utils.HutoolSnowflakeIdGenerator")
    private Long id;

    @GeneratedValue(generator = "snowflake")
    @GenericGenerator(name = "snowflake", strategy = "com.elderwan.employee.utils.HutoolStringSnowflakeIdGenerator")
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean delFlg;



}

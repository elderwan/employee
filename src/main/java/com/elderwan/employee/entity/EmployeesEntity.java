package com.elderwan.employee.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "employees")
public class EmployeesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_name", nullable = false)
    private String email;
    @Column(name = "del_flg", nullable = false, columnDefinition = "TINYINT(1) default 0")
    private Boolean delFlg;


}

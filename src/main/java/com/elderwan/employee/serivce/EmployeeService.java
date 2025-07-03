package com.elderwan.employee.serivce;

import com.elderwan.employee.dto.EmployeesDTO;
import com.elderwan.employee.utils.Response;

public interface EmployeeService {

    Response createEmployee(EmployeesDTO dto);

    Response updateEmployee(String employeeId, EmployeesDTO dto);

    Response findAllEmployee();

    Response findEmployeeById(String employeeId);

    Response deleteEmployee(String employeeId);



}

package com.elderwan.employee.serivce.impl;

import com.elderwan.employee.converter.EmployeeConverter;
import com.elderwan.employee.dto.EmployeesDTO;
import com.elderwan.employee.entity.EmployeesEntity;
import com.elderwan.employee.repository.EmployeesRepository;
import com.elderwan.employee.serivce.EmployeeService;
import com.elderwan.employee.utils.ParamsCheckUtils;
import com.elderwan.employee.utils.Response;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    EmployeesRepository employeesRepository;

    @Resource
    EmployeeConverter employeeConverter;

    @Override
    public Response createEmployee(EmployeesDTO dto) {
        EmployeesEntity save = employeesRepository.save(employeeConverter.toEmployeesEntity(dto));
        ParamsCheckUtils.isNull(save,"can not create employee now");
        return Response.ok(employeeConverter.toEmployeesDTO(save));
    }

    @Override
    public Response updateEmployee(String employeeId, EmployeesDTO dto) {
        EmployeesEntity employee = employeesRepository.findByEmployeeId(employeeId);
        ParamsCheckUtils.isNull(employee,"no this employee!");
        employeeConverter.updateEntityFromDto(dto,employee);
        EmployeesEntity updateEntity = employeesRepository.save(employee);
        return Response.ok(employeeConverter.toEmployeesDTO(updateEntity));
    }

    @Override
    public Response findAllEmployee() {
        List<EmployeesEntity> all = employeesRepository.findAll();
        return Response.ok(employeeConverter.toEmployeesDTOList(all));
    }

    @Override
    public Response findEmployeeById(String employeeId) {
        EmployeesEntity employee = employeesRepository.findByEmployeeId(employeeId);
        ParamsCheckUtils.isNull(employee,"no this employee!");
        return Response.ok(employeeConverter.toEmployeesDTO(employee));
    }

    @Override
    public Response deleteEmployee(String employeeId) {

        return null;
    }
}

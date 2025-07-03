package com.elderwan.employee.controller;

import com.elderwan.employee.dto.EmployeesDTO;
import com.elderwan.employee.serivce.EmployeeService;
import com.elderwan.employee.utils.FacadeTemplate;
import com.elderwan.employee.utils.Response;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @PostMapping("/create")
    public Response createEmployee(@RequestBody EmployeesDTO dto){
        return FacadeTemplate.template(()->employeeService.createEmployee(dto));
    }

    @PutMapping("{id}")
    public Response updateEmployee(@PathVariable("id") String employeeId,@RequestBody EmployeesDTO dto){
        return FacadeTemplate.template(()->employeeService.updateEmployee(employeeId,dto));
    }

    @RequestMapping
    public Response findAllEmployee(){
        return FacadeTemplate.template(()->employeeService.findAllEmployee());
    }

    @GetMapping("{id}")
    public Response findEmployeeById(@PathVariable("id")String employeeId){
        return FacadeTemplate.template(()->employeeService.findEmployeeById(employeeId));

    }

    @DeleteMapping("{id}")
    public Response deleteEmployee(@PathVariable("id")String employeeId){
        return FacadeTemplate.template(()->employeeService.deleteEmployee(employeeId));
    }

}

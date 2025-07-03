package com.elderwan.employee.converter;

import com.elderwan.employee.dto.EmployeesDTO;
import com.elderwan.employee.entity.EmployeesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeConverter {

    EmployeeConverter INSTANCE = Mappers.getMapper(EmployeeConverter.class);

    EmployeesEntity toEmployeesEntity(EmployeesDTO dto);

    EmployeesDTO toEmployeesDTO(EmployeesEntity entity);

    List<EmployeesDTO> toEmployeesDTOList(List<EmployeesEntity> list);

    List<EmployeesEntity> toEmployeesEntityList(List<EmployeesDTO> list);

    void updateEntityFromDto(EmployeesDTO dto, @MappingTarget EmployeesEntity entity);


}

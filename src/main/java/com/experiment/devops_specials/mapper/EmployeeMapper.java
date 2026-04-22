package com.experiment.devops_specials.mapper;

import com.experiment.devops_specials.dto.AddEmployeeDTO;
import com.experiment.devops_specials.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "department", ignore = true)
    Employee getEmployee(AddEmployeeDTO employeeDTO);
}

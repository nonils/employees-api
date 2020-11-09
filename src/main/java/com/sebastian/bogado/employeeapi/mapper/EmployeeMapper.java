package com.sebastian.bogado.employeeapi.mapper;

import com.sebastian.bogado.employeeapi.dto.EmployeeDTO;
import com.sebastian.bogado.employeeapi.model.HourlyEmployee;
import com.sebastian.bogado.employeeapi.model.MonthlyEmployee;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements OrikaMapperFactoryConfigurer {
	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(EmployeeDTO.class, HourlyEmployee.class)
				.field("id", "id")
				.field("name", "name")
				.field("roleId", "roleId")
				.field("roleName", "roleName")
				.field("roleDescription", "roleDescription")
				.field("hourlySalary", "salary")
				.byDefault()
				.register();

		orikaMapperFactory.classMap(EmployeeDTO.class, MonthlyEmployee.class)
				.field("id", "id")
				.field("name", "name")
				.field("roleId", "roleId")
				.field("roleName", "roleName")
				.field("roleDescription", "roleDescription")
				.field("monthlySalary", "salary")
				.byDefault()
				.register();
	}
}


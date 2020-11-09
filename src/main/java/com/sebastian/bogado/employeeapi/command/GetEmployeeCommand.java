package com.sebastian.bogado.employeeapi.command;

import com.sebastian.bogado.employeeapi.dto.EmployeeDTO;
import com.sebastian.bogado.employeeapi.model.AbstractEmployee;
import com.sebastian.bogado.employeeapi.model.EmployeeFactory;
import com.sebastian.bogado.employeeapi.repository.AzureEmployeeRepository;
import com.sebastian.bogado.employeeapi.service.WriteEmployeeInfoService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Order(1)
public class GetEmployeeCommand implements CommandLineRunner {

	@Autowired
	private WriteEmployeeInfoService employeeService;
	@Autowired
	private AzureEmployeeRepository employeeRepository;
	@Autowired
	private MapperFacade orikaMapper;

	@Override
	@Scheduled(fixedRateString ="${timeToSchedule:30000}", initialDelay = 1000)
	public void run(String... args) throws Exception {
		employeeService.createEmployees(employeeRepository.readEmployees().stream().map(this::mapToNewEntityEmployee).collect(Collectors.toList()));

	}

	private AbstractEmployee mapToNewEntityEmployee(EmployeeDTO employeeDTO) {
		AbstractEmployee entityEmployee = EmployeeFactory.createEmployee(employeeDTO.getContractTypeName());
		entityEmployee = orikaMapper.map(employeeDTO, entityEmployee.getClass());
		return entityEmployee;
	}
}

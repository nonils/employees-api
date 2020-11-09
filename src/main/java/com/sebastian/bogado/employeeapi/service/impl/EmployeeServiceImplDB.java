package com.sebastian.bogado.employeeapi.service.impl;

import com.sebastian.bogado.employeeapi.exception.EmployeeWasNotFound;
import com.sebastian.bogado.employeeapi.model.AbstractEmployee;
import com.sebastian.bogado.employeeapi.repository.EmployeeRepository;
import com.sebastian.bogado.employeeapi.service.ReadEmployeeInfoService;
import com.sebastian.bogado.employeeapi.service.WriteEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplDB implements ReadEmployeeInfoService, WriteEmployeeInfoService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<AbstractEmployee> readEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public AbstractEmployee readEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeWasNotFound(id));
	}

	@Override
	public void deleteAllEmployeeInfo(List<Long> ids) {

	}

	@Override
	public void createEmployees(List<AbstractEmployee> employees) {
		employeeRepository.saveAll(employees);
	}
}

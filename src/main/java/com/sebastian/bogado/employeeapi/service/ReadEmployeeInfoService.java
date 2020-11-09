package com.sebastian.bogado.employeeapi.service;

import com.sebastian.bogado.employeeapi.model.AbstractEmployee;

import java.util.List;

public interface ReadEmployeeInfoService {
	List<AbstractEmployee> readEmployees();
	AbstractEmployee readEmployeeById(Long id);
}

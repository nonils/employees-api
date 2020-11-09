package com.sebastian.bogado.employeeapi.service;

import com.sebastian.bogado.employeeapi.model.AbstractEmployee;

import java.util.List;

public interface WriteEmployeeInfoService {
	public void deleteAllEmployeeInfo(List<Long> ids);
	public void createEmployees(List<AbstractEmployee> employees);

}

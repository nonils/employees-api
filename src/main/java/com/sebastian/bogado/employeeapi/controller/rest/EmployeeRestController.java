package com.sebastian.bogado.employeeapi.controller.rest;

import com.sebastian.bogado.employeeapi.model.AbstractEmployee;
import com.sebastian.bogado.employeeapi.service.ReadEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeRestController {
	@Autowired
	private ReadEmployeeInfoService employeeInfoService;

	@GetMapping
	public List<AbstractEmployee> readAllEmployees() {
		return employeeInfoService.readEmployees();
	}

	@GetMapping("/{id}")
	public AbstractEmployee readEmployeeById(@PathVariable @NotNull Long id) {
		return employeeInfoService.readEmployeeById(id);
	}
}

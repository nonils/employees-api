package com.sebastian.bogado.employeeapi.exception;

import org.springframework.http.HttpStatus;

public class EmployeeWasNotFound extends CustomException {
	public EmployeeWasNotFound(Long id) {
		super("employee.was.not.found.exception.message", new String[]{id.toString()},"employee.was.not.found.exception.description", new String[]{id.toString()}, HttpStatus.NOT_FOUND);
	}
}

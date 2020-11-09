package com.sebastian.bogado.employeeapi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeDTO {
	private Long id;
	private String name;
	private String contractTypeName;
	private Long roleId;
	private String roleName;
	private String roleDescription;
	private BigDecimal monthlySalary;
	private BigDecimal hourlySalary;
}

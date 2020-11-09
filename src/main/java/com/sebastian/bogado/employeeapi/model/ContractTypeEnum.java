package com.sebastian.bogado.employeeapi.model;

import com.sebastian.bogado.employeeapi.exception.InvalidContractType;

import java.util.Arrays;
import java.util.Objects;

public enum ContractTypeEnum {
	HOURLY_SALARY_EMPLOYEE("HourlySalaryEmployee"),
	MONTHLY_SALARY_EMPLOYEE("MonthlySalaryEmployee");

	private final String name;

	ContractTypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static ContractTypeEnum fromNameToEnum(String value) {
		return Arrays.stream(ContractTypeEnum.values()).filter(e -> Objects.equals(e.name, value)).findFirst().orElseThrow(InvalidContractType::new);
	}
}

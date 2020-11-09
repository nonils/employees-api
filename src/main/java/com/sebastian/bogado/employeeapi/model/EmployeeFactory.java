package com.sebastian.bogado.employeeapi.model;

import com.sebastian.bogado.employeeapi.exception.InvalidContractType;

public class EmployeeFactory {

	public static AbstractEmployee createEmployee(String contractType) {
		switch (ContractTypeEnum.fromNameToEnum(contractType)) {
			case HOURLY_SALARY_EMPLOYEE:
				return new HourlyEmployee();
			case MONTHLY_SALARY_EMPLOYEE:
				return new MonthlyEmployee();
			default: throw new InvalidContractType();
		}
	}
}

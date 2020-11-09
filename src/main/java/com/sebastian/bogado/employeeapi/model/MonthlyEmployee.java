package com.sebastian.bogado.employeeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("MONTHLY_SALARY_EMPLOYEE")
public class MonthlyEmployee extends AbstractEmployee {

	@Override
	public BigDecimal getAnnualSalary() {
		return this.salary.multiply(BigDecimal.valueOf(12));
	}


	@JsonProperty("monthlySalary")
	public BigDecimal getMonthlySalary() {
		return salary;
	}
}


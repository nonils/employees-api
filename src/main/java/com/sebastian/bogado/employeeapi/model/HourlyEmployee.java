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
@DiscriminatorValue("HOURLY_SALARY_EMPLOYEE")
public class HourlyEmployee extends AbstractEmployee {

	@Override
	public BigDecimal getAnnualSalary() {
		return this.salary.multiply(BigDecimal.valueOf(12*120));
	}

	@JsonProperty("hourlySalary")
	public BigDecimal getHourlySalary() {
		return salary;
	}
}


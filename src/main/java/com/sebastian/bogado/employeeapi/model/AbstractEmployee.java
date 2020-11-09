package com.sebastian.bogado.employeeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@DiscriminatorColumn(name="contract_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="Employee")
@Data
public abstract class AbstractEmployee {
	@Id
	private Long id;
	private String name;
	private Long roleId;
	private String roleName;
	private String roleDescription;
	@JsonIgnore
	protected BigDecimal salary;

	@JsonProperty("annualSalary")
	public abstract BigDecimal getAnnualSalary();

			    /*"hourlySalary": 0,
			    "monthlySalary": 0*/

}

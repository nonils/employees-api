package com.sebastian.bogado.employeeapi.repository;

import com.sebastian.bogado.employeeapi.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class AzureEmployeeRepository {
	@Autowired
	@Qualifier("azureEmployeeRestTemplate")
	private RestTemplate restTemplate;

	public List<EmployeeDTO> readEmployees() {
		ResponseEntity<EmployeeDTO[]> result = restTemplate.getForEntity("/api/Employees", EmployeeDTO[].class);
		if (!result.getStatusCode().is2xxSuccessful()) {
			throw new RuntimeException("Impossible for read the employees from the server");
		}
		return result.getBody() == null ? Collections.emptyList() : Arrays.asList(result.getBody());
	}

}

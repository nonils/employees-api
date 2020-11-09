package com.sebastian.bogado.employeeapi.repository;

import com.sebastian.bogado.employeeapi.model.AbstractEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<AbstractEmployee, Long> {
}

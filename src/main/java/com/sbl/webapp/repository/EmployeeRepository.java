package com.sbl.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbl.webapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

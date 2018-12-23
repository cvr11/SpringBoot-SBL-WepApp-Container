package com.sbl.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbl.webapp.model.Employee;
import com.sbl.webapp.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee insert(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	public Employee findOne(Long empid) {
		return employeeRepository.findOne(empid);
	}
	
}

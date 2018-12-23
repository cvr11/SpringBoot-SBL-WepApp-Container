package com.sbl.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbl.webapp.model.Employee;
import com.sbl.webapp.repository.EmployeeRepository;
import com.sbl.webapp.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl empServiceImpl;
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return empServiceImpl.insert(emp);
	}

	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return empServiceImpl.findAll();
	}
	
	@GetMapping("/employees{Id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid) {

		Employee emp = empServiceImpl.findOne(empid);
		
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
/*	update an Employee by empId*/
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid, @Valid @RequestBody Employee empDetails){
		Employee emp = empServiceImpl.findOne(empid);
		
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setFirstName(empDetails.getFirstName());
		emp.setSalary(empDetails.getSalary());
		
		Employee updEmp = empServiceImpl.insert(emp);
		return ResponseEntity.ok().body(emp);
	} 
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		Employee emp = empServiceImpl.findOne(empid);
		
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}	
		empServiceImpl.delete(emp);
		return ResponseEntity.ok().build();
		
	}
	
}

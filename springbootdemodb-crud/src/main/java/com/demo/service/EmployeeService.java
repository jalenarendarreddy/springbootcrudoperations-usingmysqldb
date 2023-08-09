package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pojos.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
		
	}
	
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	/*public void deleteEmp(int val) {
		employeeRepository.deleteById(val);
	}*/
	
	public void deleteEmp(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	public Employee getElementById(int val) {
		return employeeRepository.getById(val);
	}
	
	public void updateEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

}

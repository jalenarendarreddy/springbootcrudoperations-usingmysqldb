package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.pojos.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

package com.example.salem.employee.dao;

import com.example.salem.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

    // method sort my lastname
    public List<Employee> findAllByOrderByLastNameAsc();
	
}

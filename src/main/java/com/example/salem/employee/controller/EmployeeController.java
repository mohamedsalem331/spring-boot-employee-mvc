package com.example.salem.employee.controller;

import com.example.salem.employee.entity.Employee;
import com.example.salem.employee.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> employees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", employees);

		return "list-employees";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		Employee employee = new Employee();

		theModel.addAttribute("employee", employee);

		return "employee-form";
	}

	@GetMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "employee-form";
	}

	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int theId, Model theModel) {
		Employee employee = employeeService.findById(theId);

		theModel.addAttribute("employee",employee);

		return "employee-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		employeeService.deleteById(theId);

		return "list-employees";
	}
}










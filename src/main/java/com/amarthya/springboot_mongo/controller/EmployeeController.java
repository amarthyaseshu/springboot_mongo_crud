package com.amarthya.springboot_mongo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarthya.springboot_mongo.model.EmployeeModel;
import com.amarthya.springboot_mongo.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// adding employee

	@PostMapping("/addEmployee")
	public EmployeeModel addEmployee(@Valid @RequestBody EmployeeModel employee) {
		return employeeService.addEmployee(employee);
	}

	// view all employees

	@GetMapping("/viewAllEmployees")
	public List<EmployeeModel> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	// view all employees in pages

	@GetMapping("/viewAllEmployeesByPage")
	public Page<EmployeeModel> getAllEmployeesByPage(Pageable pageable) {
		return employeeService.getAllEmployeesByPage(pageable);
	}

	// updating employee

	@PostMapping("/updateEmployee")
	public EmployeeModel updateEmployee(@Valid @RequestBody EmployeeModel employee) {
		return employeeService.updateEmployee(employee);
	}

	// deleting employee

	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<EmployeeModel> delete(@PathVariable("id") String id) {
		return employeeService.deleteEmployee(id);
	}

	// fetching employee by id

	@GetMapping("getEmployeeById/{id}")
	public Optional<EmployeeModel> getEmployeeById(@PathVariable("id") String id) {
		return employeeService.getEmployeeById(id);
	}

	// Fetching employee based on experience

	@GetMapping("getEmployeeByExperience/{experienceLow},{experienceHigh}")
	public List<EmployeeModel> getEmpByExpBetween(@PathVariable("experienceLow") int low,
			@PathVariable("experienceHigh") int high) {

		return employeeService.getEmpByExpBtw(low, high);
	}

	// Fetching employee based on experience in pages

	@GetMapping("getEmployeeByExperienceByPage/{experienceLow},{experienceHigh}")
	public Page<EmployeeModel> getEmpByExpBetweenByPage(@PathVariable("experienceLow") int low,
			@PathVariable("experienceHigh") int high, Pageable pageable) {

		return employeeService.getEmpByExpBtwByPage(low, high, pageable);
	}

	// fetching employee by city

	@GetMapping("getEmployeeByCity/{city}")
	public List<EmployeeModel> getEmployeeByCity(@PathVariable("city") String city) {
		return employeeService.getEmployeeByCity(city);
	}

	// fetching employee by city in pages

	@GetMapping("getEmployeeByCityBypage/{city}")
	public Page<EmployeeModel> getEmployeeByCityByPage(@PathVariable("city") String city, Pageable pageable) {
		return employeeService.getEmployeeByCityByPage(city, pageable);
	}


}

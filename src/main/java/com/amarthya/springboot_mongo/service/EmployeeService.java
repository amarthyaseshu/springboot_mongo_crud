package com.amarthya.springboot_mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amarthya.springboot_mongo.dao.EmployeeRepository;
import com.amarthya.springboot_mongo.exception.ResourceNotFoundException;
import com.amarthya.springboot_mongo.model.EmployeeModel;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;



	public EmployeeModel addEmployee(EmployeeModel employee) {

		return employeeRepo.save(employee);
	}

	public List<EmployeeModel> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Page<EmployeeModel> getAllEmployeesByPage(Pageable pageable) {

		return employeeRepo.findAll(pageable);
	}

	public EmployeeModel updateEmployee(EmployeeModel employee) {

		return employeeRepo.save(employee);
	}

	public ResponseEntity<EmployeeModel> deleteEmployee(String id) {

		employeeRepo.delete(this.employeeRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee Not Found With Given Id: " + id + " .So Cant Delete")));
		return ResponseEntity.ok().build();



	}

	public Optional<EmployeeModel> getEmployeeById(String id) {
		return Optional.of(employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with given id: " + id)));

	}

	public List<EmployeeModel> getEmpByExpBtw(int low, int high) {

		return employeeRepo.findByExperienceBetween(low, high);
	}

	public Page<EmployeeModel> getEmpByExpBtwByPage(int low, int high, Pageable pageable) {

		return employeeRepo.findByExperienceBetween(low, high, pageable);
	}

	public List<EmployeeModel> getEmployeeByCity(String city) {

		return employeeRepo.findByCity(city);
	}

	public Page<EmployeeModel> getEmployeeByCityByPage(String city, Pageable pageable) {

		return employeeRepo.findByCityByPage(city, pageable);
	}


}

package de.tekup.db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.services.EmployeeService;

@RestController
public class EmployeeCtrl {
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/employee/add")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return empService.saveToDB(employeeEntity);
	}
	
	@GetMapping("/employee/get")
	public List<EmployeeEntity> getAllEmp(){
		return empService.getAllEmployee();
	}

}

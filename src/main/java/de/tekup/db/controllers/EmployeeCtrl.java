package de.tekup.db.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.services.EmployeeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeeCtrl {

	private EmployeeService empService;
	
	@PostMapping("/employee/add")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return empService.saveToDB(employeeEntity);
	}
	
	@GetMapping("/employee/get")
	public List<EmployeeEntity> getAllEmp(){
		return empService.getAllEmployee();
	}
	
	@GetMapping("/employee/get/{id}")
	public EmployeeEntity getOneEmp(@PathVariable("id") int id){
		return empService.getEmpById(id);

	}
	
	@GetMapping("/employee/get/name/{name}")
	public EmployeeEntity getOneEmpByName(@PathVariable String name){
		return empService.getEmpByName(name);
	}
	
	@GetMapping("/employee/get/date/{d}")
	public List<EmployeeEntity> getAllEmpBornAfter(@PathVariable String d){
		LocalDate date = LocalDate.parse(d);
		return empService.getAllEmpBornAfter(date);
	}
	
	@PutMapping("/employee/update/{id}")
	public EmployeeEntity updateOneEmp(@PathVariable("id") int id,
			@RequestBody EmployeeEntity newEmployeeEntity){
		return empService.updateEmpById(id, newEmployeeEntity);

	}
	
	@DeleteMapping("/employee/delete/{id}")
	public EmployeeEntity deleteOneEmp(@PathVariable("id") int id){
		return empService.deleteOneById(id);

	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNSEE(NoSuchElementException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body("Error in search : " + e.getMessage());
	}

}

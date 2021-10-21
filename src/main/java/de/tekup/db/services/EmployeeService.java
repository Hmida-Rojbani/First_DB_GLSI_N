package de.tekup.db.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepos;
	
	public EmployeeEntity saveToDB(EmployeeEntity employeeEntity) {
		return empRepos.save(employeeEntity);
	}
	
	public List<EmployeeEntity> getAllEmployee(){
		return empRepos.findAll();
	}
	
	public EmployeeEntity getEmpById(int id) {
		Optional<EmployeeEntity> opt = empRepos.findById(id);
//		if(opt.isPresent())
//			return opt.get();
//		throw new NoSuchElementException("Employee with id is not found");
		return opt
	.orElseThrow(()-> new NoSuchElementException("Employee with id is not found"));
	}

}

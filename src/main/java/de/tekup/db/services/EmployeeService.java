package de.tekup.db.services;

import java.util.List;

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

}

package de.tekup.db.services;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

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
	
	public EmployeeEntity getEmpByName(String name) {
		Optional<EmployeeEntity> opt = empRepos.findByNameIgnoreCase(name);
//		if(opt.isPresent())
//			return opt.get();
//		throw new NoSuchElementException("Employee with id is not found");
		return opt
	.orElseThrow(()-> new NoSuchElementException("Employee with id is not found"));
	}
	
	public List<EmployeeEntity> getAllEmpBornAfter(LocalDate date){
		return empRepos.getAllBornAfter(date);
	}
	
	// update 
	public EmployeeEntity updateEmpById(int id, EmployeeEntity newEntity) {
		EmployeeEntity entity = getEmpById(id);
//		if(newEntity.getName()!=null)
//			entity.setName(newEntity.getName());
//		if(newEntity.getDob()!=null)
//			entity.setDob(newEntity.getDob());
//		if(newEntity.getEmail()!=null)
//			entity.setEmail(newEntity.getEmail());
		
		newEntity.setId(entity.getId());					
		BeanUtils.copyProperties(newEntity, entity, getNullFields(newEntity));
		
		return empRepos.save(entity);
	}
	
	// find null attributes in the received object
			private String[] getNullFields(EmployeeEntity newEntity) {
				ArrayList<String> strs = new ArrayList<String>();
				for (Field field : newEntity.getClass().getDeclaredFields()) {
			        field.setAccessible(true); // to allow the access of member attributes
			        Object attribute = null;
					try {
						attribute = field.get(newEntity);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						System.err.println(e.getMessage());
					} 
			        if (attribute == null) {
			            strs.add(field.getName());
			        }
			    }
				
				return strs.toArray(new String[0]);
			}

}

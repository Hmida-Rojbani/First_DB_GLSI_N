package de.tekup.db.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.entities.Project;
import de.tekup.db.repositories.ProjectRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectService {
	
	private ProjectRepository projetRepository;
	private EmployeeService employeeService;
	
	public Project addProject(Project project) {
		return projetRepository.save(project);
	}
	
	public Project getOneProject(int idProject) {
		return projetRepository.findById(idProject)
				.orElseThrow(()-> new NoSuchElementException("no project found"));
	}
	
	public Project addEmployeeToAProject(int idProject, int idEmp) {
		EmployeeEntity employeeEntity = employeeService.getEmpById(idEmp);
		Project project = getOneProject(idProject);
		project.getEmployees().add(employeeEntity);
		return projetRepository.save(project);
	}

}

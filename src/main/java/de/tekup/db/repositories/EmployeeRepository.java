package de.tekup.db.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.tekup.db.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

	Optional<EmployeeEntity> findByName(String name);
	Optional<EmployeeEntity> findByNameIgnoreCase(String name);
	// query in SQL 
	//@Query(value = "select * from employee  where dob >= :date", nativeQuery = true)
	// query JPQL
	@Query("Select emp from EmployeeEntity emp where emp.dob >= :date")
	List<EmployeeEntity> getAllBornAfter(@Param("date") LocalDate date);


}

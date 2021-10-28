package de.tekup.db.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.Admin;
import de.tekup.db.entities.Matricule;
import de.tekup.db.repositories.AdminRepository;
import de.tekup.db.repositories.MatriculeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {
	
	private AdminRepository adRepos;
	private MatriculeRepository matRepos;
	//  add Admin
	public Admin saveToDB(Admin admin) {
	return adRepos.save(admin);
	}
	// get Admin by Id
	public Admin getAdminById(int id) {
	Optional<Admin> opt = adRepos.findById(id);

	return opt.orElseThrow(()-> new	NoSuchElementException("admin with id is not found") );
	}
	
	// add Matricule to an admin
	
	public Matricule addMatriculeToAdmin(int idAdmin
			, Matricule matricule) {
		Admin admin = getAdminById(idAdmin);
		matricule.setCreator(admin);
		//admin.getMatricules().add(matricule);
		return matRepos.save(matricule);
		
	}

}

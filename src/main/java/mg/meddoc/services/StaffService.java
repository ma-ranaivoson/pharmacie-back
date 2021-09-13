package mg.meddoc.services;

import mg.meddoc.models.Staff;

public interface StaffService extends CRUDService<Staff>{
	Staff rechercheStaff(String nom_staf);
	
	void deleteStaff(Staff staff);
	
	Staff findByIdStaff(Long id);
}

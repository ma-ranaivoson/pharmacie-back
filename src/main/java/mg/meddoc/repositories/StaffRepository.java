package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{
	@Query(nativeQuery=true,value="SELECT staff.* FROM staff WHERE nom_staf=?1")
	Staff rechercheStaff(String nom_staf);
}

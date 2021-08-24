package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import mg.meddoc.models.adresses.Commune;
import mg.meddoc.models.*;

public interface CommuneRep extends JpaRepository<Commune, Integer> {
	
	@Query(nativeQuery=true,value="UPDATE commune SET id_statut = ?2 WHERE id_commune = ?1")
	void modifierStatutByStatut(Long id, Long idStatut);
	
	List<Commune> findByDistrictIdDistrict(Long idDistrict);
}

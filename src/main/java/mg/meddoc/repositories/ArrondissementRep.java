package mg.meddoc.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import mg.meddoc.models.adresses.Arrondissement;
import mg.meddoc.models.*;

public interface ArrondissementRep extends JpaRepository<Arrondissement, Integer> {
	
	@Query(nativeQuery=true,value="UPDATE arrondissement SET id_statut = ?2 WHERE id_arrondissement = ?1")
	void modifierStatutByStatut(Long id, Long idStatut);
	
	List<Arrondissement> findByCommuneIdCommune(Long idCommune);
}

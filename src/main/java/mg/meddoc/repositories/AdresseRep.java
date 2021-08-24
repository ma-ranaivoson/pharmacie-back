package mg.meddoc.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import mg.meddoc.models.adresses.Adresse;
//import mg.meddoc.models.adresses.AdressePK;
import mg.meddoc.models.*;

public interface AdresseRep extends JpaRepository<Adresse, AdressePK> {
	
	@Query(nativeQuery=true,value="UPDATE adresse SET id_statut = ?2 WHERE id_contact = ?1")
	void modifierStatutByStatut(Long id, Long idStatut);
}


package mg.meddoc.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Pharmacie;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {
	//izay requête rehetra tina atao
	//@Query(nativeQuery=true,value="UPDATE adresse SET id_statut = ?2 WHERE id_adresse = ?1")
	//	void modifierStatutByStatut(Long id, Long idStatut);
	
	//Recherche par Nom du Pharmacie
	@Query(nativeQuery=true,value="SELECT pharmacie.* FROM pharmacie WHERE raison_social = ?")
	Pharmacie recherchePharmacie(String raisonSocial);
	
	Page<Pharmacie> findByRaisonSocialContainingIgnoreCase(String raisonSocial, Pageable page);
	
	//Liste Pharma eto Tana
	
}

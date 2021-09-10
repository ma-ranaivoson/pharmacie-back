package mg.meddoc.services;

import java.util.List;

import org.springframework.data.domain.Page;

import mg.meddoc.models.Pharmacie;

public interface PharmacieService extends CRUDService<Pharmacie>{
	Pharmacie recherchePharmacie(String raisonSocial);
	
	//zavatra tadiavina
	//page = numero page
	//size = firy ligne
	//sort = nom attribut pharmacie.
	//Direction = asc ou desc
	//
	//SELECT * FROM pharmacie WHERE UPPER(raison_social) LIKE (?1) ORDER BY raison_social ASC LIMIT 10 OFFSET 0
	Page<Pharmacie> findByRaisonSocialContainingIgnoreCase(String raisonSocial, int page, int size, String sort, String direction);	
	List<Pharmacie> findByUtilisateursIdUtilisateur(Long id);
	Pharmacie getByRaisonSocial(String raisonSocial);	
	Pharmacie getPharmacieById(Long id);	
	Long getNextSeq();	
	Pharmacie findByRaisonSocialAndAdresseDistrictNomDistrict(String raisonSocial, String nomDistrict);
	List<Pharmacie> findByDoClickAndCollect();
}

package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.SousCategorie;

public interface SousCategorieService extends CRUDService<SousCategorie>{
	SousCategorie rechercheSousCategorie(String libelle);
	
	List<SousCategorie> findByIdCategorie(Long idCategorie);
}

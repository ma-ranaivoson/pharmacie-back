package mg.meddoc.services;

import mg.meddoc.models.SousCategorie;

public interface SousCategorieService extends CRUDService<SousCategorie>{
	SousCategorie rechercheSousCategorie(String libelle);
}

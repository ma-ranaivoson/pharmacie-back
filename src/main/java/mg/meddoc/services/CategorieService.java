package mg.meddoc.services;

import mg.meddoc.models.Categorie;

public interface CategorieService extends CRUDService<Categorie>{
	Categorie rechercheCategorie(String libelle);
}

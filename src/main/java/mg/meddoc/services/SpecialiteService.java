package mg.meddoc.services;

import mg.meddoc.models.Specialite;

public interface SpecialiteService extends CRUDService<Specialite>{
	Specialite rechercheSpecialite(String libelle);
}

package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.Specialite;

public interface SpecialiteService extends CRUDService<Specialite>{
	Specialite rechercheSpecialite(String libelle);
	List<Specialite> findSpecialiteIdPharmacie(Long id);
}

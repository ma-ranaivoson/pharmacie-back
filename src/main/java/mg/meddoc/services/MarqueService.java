package mg.meddoc.services;

import mg.meddoc.models.Marque;

public interface MarqueService extends CRUDService<Marque>{
	Marque rechercheMarque(String nomination);
}

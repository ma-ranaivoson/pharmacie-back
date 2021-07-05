package mg.meddoc.services;

import mg.meddoc.models.Pharmacie;

public interface PharmacieService extends CRUDService<Pharmacie>{
	Pharmacie recherchePharmacie(String raisonSocial);
}

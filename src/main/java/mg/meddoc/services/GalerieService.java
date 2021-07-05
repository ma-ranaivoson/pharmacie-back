package mg.meddoc.services;

import mg.meddoc.models.Galerie;

public interface GalerieService extends CRUDService<Galerie>{
	Galerie rechercheGalerie(String nom_photo);
}

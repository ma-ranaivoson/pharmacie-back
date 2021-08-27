package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.Galerie;

public interface GalerieService extends CRUDService<Galerie>{
	Galerie rechercheGalerie(String nom_photo);
	
	List<String> search_album(Long idPharmacie);
}

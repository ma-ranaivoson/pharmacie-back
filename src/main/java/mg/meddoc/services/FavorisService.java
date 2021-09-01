package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.Favoris;

public interface FavorisService extends CRUDService<Favoris>{
	Favoris rechercheFavoris(String valeur);
	
	List<Favoris> findByUsersId(Long id);
}

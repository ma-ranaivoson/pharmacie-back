package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Favoris;
import mg.meddoc.models.FavorisPK;

public interface UserModePaiement extends JpaRepository<Favoris, FavorisPK>{
	@Query(nativeQuery=true,value="SELECT Favoris.* FROM Favoris WHERE valeur=?1")
	Favoris rechercheFavoris(String valeur);
	
	List<Favoris> findByUsersId(Long id);
}

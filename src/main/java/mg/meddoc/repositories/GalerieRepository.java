package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Galerie;
import mg.meddoc.models.GaleriePK;

public interface GalerieRepository extends JpaRepository<Galerie, GaleriePK>{
	@Query(nativeQuery=true,value="SELECT galerie.* FROM galerie WHERE nom_photo=?1")
	Galerie rechercheGalerie(String nom_photo);
	
	@Query(nativeQuery=true,value="SELECT galerie.album FROM galerie WHERE id_pharmacie=?1 GROUP BY album")
	List<String> search_album(Long idPharmacie);
}

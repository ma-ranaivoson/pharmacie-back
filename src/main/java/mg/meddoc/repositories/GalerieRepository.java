package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Galerie;
import mg.meddoc.models.GaleriePK;

public interface GalerieRepository extends JpaRepository<Galerie, GaleriePK>{
	@Query(nativeQuery=true,value="SELECT galerie.* FROM galerie WHERE nom_photo=?1")
	Galerie rechercheGalerie(String nom_photo);
}

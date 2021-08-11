package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.SousCategorie;

public interface SousCategorieRepository extends JpaRepository<SousCategorie, Long>{
	@Query(nativeQuery=true,value="SELECT sous_categorie.* FROM sous_categorie WHERE libelle=?1")
	SousCategorie rechercheSousCategorie(String libelle);
	
	List<SousCategorie> findByIdCategorie(Long idCategorie);
}

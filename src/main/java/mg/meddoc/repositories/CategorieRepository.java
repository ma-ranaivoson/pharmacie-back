package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import mg.meddoc.models.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	@Query(nativeQuery=true,value="SELECT categorie.* FROM categorie WHERE libelle=?1")
	Categorie rechercheCategorie(String libelle);
}

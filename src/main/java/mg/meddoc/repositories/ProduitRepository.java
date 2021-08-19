package mg.meddoc.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.meddoc.models.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	@Query(nativeQuery=true,value="SELECT produit.* FROM produit WHERE designation=?1")
	Produit rechercheProduit(String designation);	
	Page<Produit> findByDesignationContainingIgnoreCase(String designation,Pageable page);
	Page<Produit> findByMarqueNomination(String nomination, Pageable page);
	Page<Produit> findByCategorieIdSouCategorie(Long idSouscategorie, Pageable page);
	Page<Produit> findByCategorieIdCategorie(Long idCategorie, Pageable page);
}

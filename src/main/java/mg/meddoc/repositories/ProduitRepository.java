package mg.meddoc.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.meddoc.models.Pharmacie;
import mg.meddoc.models.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	@Query(nativeQuery=true,value="SELECT produit.* FROM produit WHERE designation=?1")
	Produit rechercheProduit(String designation);	
	Page<Produit> findByDesignationContainingIgnoreCase(String designation,Pageable page);
	Page<Produit> findByMarqueNomination(String nomination, Pageable page);
	Page<Produit> findByCategorieIdSouCategorie(Long idSouscategorie, Pageable page);
	Page<Produit> findByCategorieIdCategorie(Long idCategorie, Pageable page);
	Produit findByIdProduit(Long id);
	List<Pharmacie> findByPharmacieIdPharmacie(Long id);
	@Query(nativeQuery=true,value="SELECT pharma.* FROM produit prod join pharmacie pharma on prod.id_pharmacie=pharma.id_pharmacie WHERE prod.id_produit=?1")
	List<Pharmacie> findByPharmacieIdProduit(Long id);
}

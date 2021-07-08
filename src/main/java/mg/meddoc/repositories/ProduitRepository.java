package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	@Query(nativeQuery=true,value="SELECT produit.* FROM produit WHERE designation=?1")
	Produit rechercheProduit(String designation);
}

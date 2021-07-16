package mg.meddoc.services;

import org.springframework.data.domain.Page;

import mg.meddoc.models.Produit;

public interface ProduitService extends CRUDService<Produit>{
	Produit rechercheProduit(String designation);
	
	Page<Produit> findByDesignationContainingIgnoreCase(String designation,int page,int size,String columnSort, String direction);
}

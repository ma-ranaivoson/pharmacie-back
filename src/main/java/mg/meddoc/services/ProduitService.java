package mg.meddoc.services;

import org.springframework.data.domain.Page;
import mg.meddoc.models.*;

public interface ProduitService extends CRUDService<Produit>{
	Produit rechercheProduit(String designation);	
	Page<Produit> findByDesignationContainingIgnoreCase(String designation, int page, int size, String sort, String direction);	
	Page<Produit> getAllProductPage( int page, int size,String direction, String sort);	
	Page<Produit> getAllProductByMarque(String nomination, int page, int size,String direction, String sort);
	Page<Produit> getAllProductByCategorie(Long idCategorie, int page, int size, String direction, String sort);
	Page<Produit> getAllProductBySousCategorie(Long idSousCategorie, int page, int size, String direction, String sort);
}

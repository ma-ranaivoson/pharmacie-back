package mg.meddoc.services;

import mg.meddoc.models.Produit;

public interface ProduitService extends CRUDService<Produit>{
	Produit recherchePharmacie(String designation);
}

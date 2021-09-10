package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.Panier;
import mg.meddoc.models.Pharmacie;

public interface PanierService extends CRUDService<Panier>{
	List<Panier> getPanierNotPaid(Long id);
	List<Panier> getUserCart(Long id);
	Panier getCartByIdProduct(Long idProduct,Long idPharmacie, Long idUser);
}

package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Panier;
import mg.meddoc.models.PanierPK;


public interface PanierRepository extends JpaRepository<Panier, PanierPK>{
	@Query(nativeQuery=true, value="select pan.* from panier pan where pan.id_utilisateur=?1 and id_paiement is null")
	List<Panier> findByIdUtilisateurAndIdPaiementIsNull(Long id);	
	List<Panier> findByIdUtilisateur(Long id);
	Panier findByIdProduitAndIdPharmacieAndIdUtilisateur(Long idProduct, Long idPharmacie ,Long idUser);
	List<Panier> findByIdUtilisateurAndIdPaiementIsNotNull(Long id);
}

package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.Panier;
import mg.meddoc.models.PanierPK;

public interface PanierRepository extends JpaRepository<Panier, PanierPK>{
	
}

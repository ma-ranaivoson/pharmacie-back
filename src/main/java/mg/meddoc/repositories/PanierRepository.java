package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long>{
	
}

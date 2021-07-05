package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long>{
	
}

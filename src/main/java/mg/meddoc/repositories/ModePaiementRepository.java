package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.ModePaiement;

public interface ModePaiementRepository extends JpaRepository<ModePaiement, Long>{
	
}

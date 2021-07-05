package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long>{
	
}

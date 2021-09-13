package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.MouvementStock;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long>{
	
}

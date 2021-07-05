package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.Garde;

public interface GardeRepository extends JpaRepository<Garde, Long>{
	
}

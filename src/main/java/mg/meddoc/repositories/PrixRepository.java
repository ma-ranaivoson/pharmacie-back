package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import mg.meddoc.models.Prix;

public interface PrixRepository extends JpaRepository<Prix, Long>{
	
}

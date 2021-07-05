package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import mg.meddoc.models.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long>{
	@Query(nativeQuery=true,value="SELECT marque.* FROM marque WHERE nomination=?1")
	Marque rechercheMarque(String nomination);
}

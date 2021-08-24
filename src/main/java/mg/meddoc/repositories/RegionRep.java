package mg.meddoc.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import mg.meddoc.models.adresses.Region;
import mg.meddoc.models.*;

public interface RegionRep extends JpaRepository<Region, Integer> {
	
	@Query(nativeQuery=true,value="UPDATE region SET id_statut = ?2 WHERE id_region = ?1")
	void modifierStatutByStatut(Long id, Long idStatut);
	
//	List<Region> findByProvinceIdProvince(Long idProvince);

	Page<Region> findByProvinceIdProvince(Long idProvince, Pageable page);
}

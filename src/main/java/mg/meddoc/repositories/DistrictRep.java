package mg.meddoc.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import mg.meddoc.models.adresses.District;
import mg.meddoc.models.*;

public interface DistrictRep extends JpaRepository<District, Integer> {
	
	@Query(nativeQuery=true,value="UPDATE district SET id_statut = ?2 WHERE id_district = ?1")
	void modifierStatutByStatut(Long id, Long idStatut);
	
	List<District> findByRegionIdRegion(Long idRegion);
	
//	List<District> findByRegionProvinceIdProvince(Long idProvince);

	Page<District> findByRegionProvinceIdProvince(Long idProvince, Pageable page);
}

package mg.meddoc.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import mg.meddoc.models.adresses.Province;
import mg.meddoc.models.*;

public interface ProvinceRep extends JpaRepository<Province, Integer> {
	
	@Query(nativeQuery=true,value="UPDATE province SET id_statut = ?2 WHERE id_province = ?1")
	void modifierStatutByStatut(Long id, Long idStatut);
	
	Page<Province> findAll(Pageable page);
	
	@Query(nativeQuery=true,value="SELECT prov.id_province FROM province prov join region reg on prov.id_province=reg.id_province join district dist on reg.id_region=dist.id_region WHERE dist.id_district=?1")
	Integer getIdProvinceByIdDistrict(Integer id);
}

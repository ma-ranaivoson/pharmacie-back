package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Contact;
import mg.meddoc.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{
	@Query(nativeQuery=true,value="SELECT service.* FROM service WHERE libelle=?1")
	Service recherchePharmacie(String libelle);
	
//	List<Service> findByIdPharmacie(Long idPharmacie);
//	List<Service> findByPharmacieIdPharmacie(Long id);
}

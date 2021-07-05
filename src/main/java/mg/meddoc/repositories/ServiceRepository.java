package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{
	@Query(nativeQuery=true,value="SELECT service.* FROM service WHERE libelle=?1")
	Service recherchePharmacie(String libelle);
}

package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Contact;
import mg.meddoc.models.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long>{
	@Query(nativeQuery=true,value="SELECT specialite.* FROM specialite WHERE libelle=?1")
	Specialite rechercheSpecialite(String libelle);
	
	@Query(nativeQuery=true,value="SELECT spec.* from rel_specialite_pharmacie rel join specialite spec on rel.id_specialite=spec.id_specialite where rel.id_pharmacie=?1")
	List<Specialite> findSpecialiteIdPharmacie(Long id);
	
}

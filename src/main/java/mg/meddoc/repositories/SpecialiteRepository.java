package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long>{
	@Query(nativeQuery=true,value="SELECT specialite.* FROM specialite WHERE libelle=?1")
	Specialite rechercheSpecialite(String libelle);
}

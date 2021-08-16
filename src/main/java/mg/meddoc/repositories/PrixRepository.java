package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.Prix;
import mg.meddoc.models.PrixPK;

public interface PrixRepository extends JpaRepository<Prix, PrixPK>{
	Prix findByIdProduit(Long prix);
}

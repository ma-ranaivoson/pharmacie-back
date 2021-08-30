package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.Prix;
import mg.meddoc.models.PrixPK;

public interface PrixRepository extends JpaRepository<Prix, PrixPK>{
//	Prix findByIdProduit(Long prix);
	Prix findPrixByIdProduitAndIdPharmacie(Long idProduit,long idPharmacie);
	Prix findByIdPharmacie(Long idPharmacie);
	List<Prix> findByIdProduit(Long prix);
}

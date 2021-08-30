package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.Prix;

public interface PrixService extends CRUDService<Prix>{
	Prix getProductPrice(Long id);
	Prix getPrixByIdProduitAndIdPharmacie(Long idProduit,long idPharmacie);
	Prix getPrixByIdPharmacie(Long idPharmacie);
	List<Prix> findByIdProduit(Long prix);
}

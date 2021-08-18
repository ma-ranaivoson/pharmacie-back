package mg.meddoc.services;

import mg.meddoc.models.Prix;

public interface PrixService extends CRUDService<Prix>{
	Prix getProductPrice(Long id);
	Prix getPrixByIdProduitAndIdPharmacie(Long idProduit,long idPharmacie);
}

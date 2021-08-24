package mg.meddoc.services;
import java.util.List;

//import mg.meddoc.models.adresses.Arrondissement;
import mg.meddoc.models.*;
import mg.meddoc.services.CRUDService;

public interface ArrondissementSer extends CRUDService<Arrondissement> {

	List<Arrondissement> findByCommuneIdCommune(Long idCommune);
}

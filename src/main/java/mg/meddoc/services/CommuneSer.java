package mg.meddoc.services;
import java.util.List;
//import mg.meddoc.models.adresses.Commune;
import mg.meddoc.models.*;
import mg.meddoc.services.CRUDService;

public interface CommuneSer extends CRUDService<Commune> {

	List<Commune> findByDistrictIdDistrict(Long idDistrict);
}

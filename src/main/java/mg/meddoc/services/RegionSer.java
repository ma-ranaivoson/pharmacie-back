package mg.meddoc.services;
import java.util.List;
//import mg.meddoc.models.adresses.Region;
import mg.meddoc.models.*;
import mg.meddoc.services.CRUDService;

public interface RegionSer extends CRUDService<Region> {

	List<Region> findByProvinceIdProvince(Long idProvince);
}

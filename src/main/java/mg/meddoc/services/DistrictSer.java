package mg.meddoc.services;
import java.util.List;
//import mg.meddoc.models.adresses.District;
import mg.meddoc.models.*;
import mg.meddoc.services.CRUDService;

public interface DistrictSer extends CRUDService<District> {

	List<District> findByRegionIdRegion(Long idRegion);
	
	List<District>findByRegionProvinceIdProvince(Long idProvince);
}

package mg.meddoc.services;
import java.util.List;
//import mg.meddoc.models.adresses.Province;
import mg.meddoc.models.*;
import mg.meddoc.services.CRUDService;

public interface ProvinceSer extends CRUDService<Province> {
	List<Province> findAll();
	
	Integer getIdProvinceByIdDistrict(Integer id);
}

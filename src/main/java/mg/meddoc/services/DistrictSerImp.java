package mg.meddoc.services;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

//import mg.meddoc.models.adresses.District;
//import mg.meddoc.repositories.adresses.DistrictRep;
import mg.meddoc.models.*;
import mg.meddoc.repositories.*;

@Service
public class DistrictSerImp implements DistrictSer {
	
	@Autowired
	private DistrictRep repository;

	@Override
	public District save(District entity) {
		return repository.save(entity);
	}

	@Override
	public List<District> saveAll(List<District> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public District getById(Serializable id) {
		return repository.findById((Integer) id).get();
	}

	@Override
	public List<District> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<District> getAllPageable(int page, int max, String col, String direction) {
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		repository.deleteById((Integer) id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		repository.modifierStatutByStatut((Long)id, (Long)idStatut);
		
	}

	@Override
	public List<District> findByRegionIdRegion(Long idRegion) {
		return repository.findByRegionIdRegion(idRegion);
	}

	@Override
	public List<District> findByRegionProvinceIdProvince(Long idProvince) {
		return repository.findByRegionProvinceIdProvince(idProvince, PageRequest.of(0, 100, Direction.ASC, "nomDistrict")).getContent();
	}

}

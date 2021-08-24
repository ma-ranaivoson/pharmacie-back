package mg.meddoc.services;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

//import mg.meddoc.models.adresses.Region;
//import mg.meddoc.repositories.adresses.RegionRep;
import mg.meddoc.models.*;
import mg.meddoc.repositories.*;

@Service
public class RegionSerImp implements RegionSer {
	
	@Autowired
	private RegionRep repository;

	@Override
	public Region save(Region entity) {
		return repository.save(entity);
	}

	@Override
	public List<Region> saveAll(List<Region> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public Region getById(Serializable id) {
		return repository.findById((Integer) id).get();
	}

	@Override
	public List<Region> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<Region> getAllPageable(int page, int max, String col, String direction) {
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
	public List<Region> findByProvinceIdProvince(Long idProvince) {
		return repository.findByProvinceIdProvince(idProvince, PageRequest.of(0, 100, Direction.ASC, "nomRegion")).getContent();
	}
}

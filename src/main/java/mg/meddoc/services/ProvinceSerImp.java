package mg.meddoc.services;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

//import mg.meddoc.models.adresses.Province;
//import mg.meddoc.repositories.adresses.ProvinceRep;
import mg.meddoc.models.*;
import mg.meddoc.repositories.*;

@Service
public class ProvinceSerImp implements ProvinceSer {
	
	@Autowired
	private ProvinceRep repository;

	@Override
	public Province save(Province entity) {
		return repository.save(entity);
	}

	@Override
	public List<Province> saveAll(List<Province> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public Province getById(Serializable id) {
		return repository.findById((Integer) id).get();
	}
	
	@Override
	public List<Province> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Province> findAll() {
		return repository.findAll(PageRequest.of(0, 100, Direction.ASC, "nomProvince")).getContent();
	}

	@Override
	public Page<Province> getAllPageable(int page, int max, String col, String direction) {
		PageRequest pageRequest = PageRequest.of((page-1), max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of((page-1), max, Direction.DESC, col);
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
	public Integer getIdProvinceByIdDistrict(Integer id) {
		return repository.getIdProvinceByIdDistrict(id);
	}
}

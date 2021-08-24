package mg.meddoc.services;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

//import mg.meddoc.models.adresses.Commune;
//import mg.meddoc.repositories.adresses.CommuneRep;
import mg.meddoc.models.*;
import mg.meddoc.repositories.*;

@Service
public class CommuneSerImp implements CommuneSer {
	
	@Autowired
	private CommuneRep repository;

	@Override
	public Commune save(Commune entity) {
		return repository.save(entity);
	}

	@Override
	public List<Commune> saveAll(List<Commune> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public Commune getById(Serializable id) {
		return repository.findById((Integer) id).get();
	}

	@Override
	public List<Commune> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<Commune> getAllPageable(int page, int max, String col, String direction) {
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
	public List<Commune> findByDistrictIdDistrict(Long idDistrict) {
		return repository.findByDistrictIdDistrict(idDistrict);
	}
}

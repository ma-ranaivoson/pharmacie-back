package mg.meddoc.services;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

//import mg.meddoc.models.adresses.Adresse;
//import mg.meddoc.models.adresses.AdressePK;
//import mg.meddoc.repositories.adresses.AdresseRep;
import mg.meddoc.models.*;
import mg.meddoc.repositories.*;

@Service
public class AdresseSerImp implements AdresseSer {
	
	@Autowired
	private AdresseRep repository;

	@Override
	public Adresse save(Adresse entity) {
		return repository.save(entity);
	}

	@Override
	public List<Adresse> saveAll(List<Adresse> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public Adresse getById(Serializable id) {
		return repository.findById((AdressePK) id).get();
	}

	@Override
	public List<Adresse> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<Adresse> getAllPageable(int page, int max, String col, String direction) {
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		repository.deleteById((AdressePK) id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		repository.modifierStatutByStatut((Long)id, (Long)idStatut);
		
	}

}

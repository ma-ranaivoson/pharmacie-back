package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.ModePaiement;
import mg.meddoc.repositories.ModePaiementRepository;

@Service
public class ModePaiementImplementation implements ModePaiementService {

	@Autowired
	ModePaiementRepository repository;

	@Override
	public ModePaiement save(ModePaiement entity) {
		return repository.save(entity);
	}

	@Override
	public List<ModePaiement> saveAll(List<ModePaiement> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public ModePaiement getById(Serializable id) {
		return repository.findById((Long) id).get();
	}

	@Override
	public List<ModePaiement> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<ModePaiement> getAllPageable(int page, int max, String col, String direction) {
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if (direction.trim().compareToIgnoreCase("desc") == 0
				|| direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		repository.deleteById((Long) id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
	}

}

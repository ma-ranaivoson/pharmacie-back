package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.UserModePaiement;
import mg.meddoc.models.UserModePaiementPK;
import mg.meddoc.repositories.UserModePaiementRepository;

@Service
public class UserModePaiementImplementation implements UserModePaiementService {

	@Autowired
	private UserModePaiementRepository repository;

	@Override
	public UserModePaiement save(UserModePaiement entity) {
		return repository.save(entity);
	}

	@Override
	public List<UserModePaiement> saveAll(List<UserModePaiement> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public UserModePaiement getById(Serializable id) {
		return repository.findById((UserModePaiementPK) id).get();
	}

	@Override
	public List<UserModePaiement> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<UserModePaiement> getAllPageable(int page, int max, String col, String direction) {
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if (direction.trim().compareToIgnoreCase("desc") == 0
				|| direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		repository.deleteById((UserModePaiementPK) id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
	}

	@Override
	public List<UserModePaiement> findByIdUtilisateur(Long id) {
		return repository.findByIdUtilisateur(id);
	}

	

}

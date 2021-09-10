package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.ClickAndCollect;
import mg.meddoc.models.ClickAndCollectPK;
import mg.meddoc.repositories.ClickAndCollectRepository;

@Service
public class ClickAndCollectImplementation implements ClickAndCollectService {

	@Autowired
	private ClickAndCollectRepository repository;

	@Override
	public ClickAndCollect save(ClickAndCollect entity) {
		return repository.save(entity);
	}

	@Override
	public List<ClickAndCollect> saveAll(List<ClickAndCollect> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public ClickAndCollect getById(Serializable id) {
		return repository.findById((ClickAndCollectPK) id).get();
	}

	@Override
	public List<ClickAndCollect> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<ClickAndCollect> getAllPageable(int page, int max, String col, String direction) {
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if (direction.trim().compareToIgnoreCase("desc") == 0
				|| direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		repository.deleteById((ClickAndCollectPK) id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
	}

}

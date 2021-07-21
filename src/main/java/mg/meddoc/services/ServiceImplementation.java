package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.repositories.ServiceRepository;


@Service
public class ServiceImplementation implements ServiceService{
	
	@Autowired
	private ServiceRepository repository;

	@Override
	public mg.meddoc.models.Service save(mg.meddoc.models.Service entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<mg.meddoc.models.Service> saveAll(List<mg.meddoc.models.Service> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public mg.meddoc.models.Service getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((Long) id).get();
	}

	@Override
	public List<mg.meddoc.models.Service> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<mg.meddoc.models.Service> getAllPageable(int page, int max, String col, String direction) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		repository.deleteById((Long)id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public mg.meddoc.models.Service recherchePharmacie(String libelle) {
		// TODO Auto-generated method stub
		return repository.recherchePharmacie(libelle);
	}
	
	

}

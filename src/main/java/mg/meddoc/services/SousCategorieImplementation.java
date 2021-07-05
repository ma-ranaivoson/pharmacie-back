package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.SousCategorie;
import mg.meddoc.repositories.SousCategorieRepository;

@Service
public class SousCategorieImplementation implements SousCategorieService{
	
	@Autowired
	private SousCategorieRepository repository;
	
	@Override
	public SousCategorie save(SousCategorie entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<SousCategorie> saveAll(List<SousCategorie> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public SousCategorie getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((Long) id).get();
	}

	@Override
	public List<SousCategorie> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<SousCategorie> getAllPageable(int page, int max, String col, String direction) {
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
	public SousCategorie rechercheSousCategorie(String libelle) {
		// TODO Auto-generated method stub
		return repository.rechercheSousCategorie(libelle);
	}

}

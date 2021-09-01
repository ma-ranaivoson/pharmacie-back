package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Favoris;
import mg.meddoc.models.FavorisPK;
import mg.meddoc.repositories.FavorisRepository;

@Service
public class FavorisImplementation implements FavorisService{
	
	@Autowired
	private FavorisRepository repository;
	
	@Override
	public Favoris save(Favoris entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Favoris> saveAll(List<Favoris> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Favoris getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((FavorisPK) id).get();
	}

	@Override
	public List<Favoris> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Favoris> getAllPageable(int page, int max, String col, String direction) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		repository.deleteById((FavorisPK)id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Favoris rechercheFavoris(String valeur) {
		// TODO Auto-generated method stub
		return repository.rechercheFavoris(valeur);
	}

	@Override
	public List<Favoris> findByUsersId(Long id) {
		// TODO Auto-generated method stub
		return repository.findByUsersId(id);
	}

}

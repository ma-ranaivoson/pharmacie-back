package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Type_Contact;
import mg.meddoc.repositories.Type_ContactRepository;

@Service
public class Type_ContactImplementation implements Type_ContactService{
	
	@Autowired
	private Type_ContactRepository repository;
	
	
	@Override
	public Type_Contact save(Type_Contact entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Type_Contact> saveAll(List<Type_Contact> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Type_Contact getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((Long) id).get();
	}

	@Override
	public List<Type_Contact> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Type_Contact> getAllPageable(int page, int max, String col, String direction) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		// TODO Auto-generated method stub
		repository.deleteById((Long)id);
	}

	@Override
	public Type_Contact rechercheType_Contact(String libelle) {
		// TODO Auto-generated method stub
		return repository.rechercheType_Contact(libelle);
	}

}

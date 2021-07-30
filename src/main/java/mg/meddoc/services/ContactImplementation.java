package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Contact;
import mg.meddoc.models.ContactPK;
import mg.meddoc.repositories.ContactRepository;

@Service
public class ContactImplementation implements ContactService{
	
	@Autowired
	private ContactRepository repository;
	
	@Override
	public Contact save(Contact entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Contact> saveAll(List<Contact> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Contact getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((ContactPK) id).get();
	}

	@Override
	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Contact> getAllPageable(int page, int max, String col, String direction) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		repository.deleteById((ContactPK)id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact rechercheContact(String valeur) {
		// TODO Auto-generated method stub
		return repository.rechercheContact(valeur);
	}

}

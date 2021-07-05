package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Utilisateur;
import mg.meddoc.repositories.UtilisateurRepository;

@Service
public class UtilisateurImplementation implements UtilisateurService{
	
	@Autowired
	private UtilisateurRepository repository;
	
	@Override
	public Utilisateur save(Utilisateur entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Utilisateur> saveAll(List<Utilisateur> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Utilisateur getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((Long) id).get();
	}

	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Utilisateur> getAllPageable(int page, int max, String col, String direction) {
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
	public Utilisateur rechercheUtilisateur(String nom) {
		// TODO Auto-generated method stub
		return repository.rechercheUtilisateur(nom);
	}

}

package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mg.meddoc.models.User;
import mg.meddoc.models.Utilisateur;
import mg.meddoc.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceImplementation implements UtilisateurService {
	
	@Autowired
	private UtilisateurRepository repository;

	ObjectMapper om = new ObjectMapper();
	
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
		try {
			return repository.findById((Long) id).orElseThrow(() -> new Exception("Not found"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
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

	@Override
	public UserDetails loadUserByUsername(String adresse) throws UsernameNotFoundException {
		Utilisateur user = repository.findByAdresse(adresse);
		try {
			System.out.println(om.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user==null)
			throw new UsernameNotFoundException("User Not Found with -> username or email : " + adresse);

		return user;
	}

	@Override
	public Boolean existsByAdresse(String adresse) {
		boolean res = repository.existsByAdresse(adresse);
		System.out.println(res);
		return res;
	}

	@Override
	public Utilisateur findByAdresse(String adresse) {
		return repository.findByAdresse(adresse);
	}

}

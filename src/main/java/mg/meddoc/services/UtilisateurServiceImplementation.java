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
//			return repository.findById((Long) id).orElseThrow(() -> new Exception("Not found"));
			Utilisateur user = repository.findById((Long)id).get();
			System.out.println("Eto==> "+om.writeValueAsString(user));
			return user;
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
	public UserDetails loadUserByUsername(String identification) throws UsernameNotFoundException {
//		Utilisateur user = repository.findByEmail(identification);
//		if(user==null)
//			user = repository.findByPhone(identification);
		Utilisateur user = null;
		if(isNumber(identification)) {
			user = repository.findById(Long.parseLong(identification)).get();
		}else {
			user = repository.findByEmail(identification);
			if(user==null)
				user = repository.findByPhone(identification);
		}
		try {
//			System.out.println(om.writeValueAsString(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user==null)
			throw new UsernameNotFoundException("User Not Found with -> username or email : " + identification);

		return user;
	}

	@Override
	public Boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.existsByEmail(email);
	}

	@Override
	public Utilisateur findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

	@Override
	public Boolean existsByPhone(String phone) {
		// TODO Auto-generated method stub
		return repository.existsByPhone(phone);
	}

	@Override
	public Utilisateur findByPhone(String phone) {
		// TODO Auto-generated method stub
		return repository.findByPhone(phone);
	}

	@Override
	public Utilisateur findByIdentifiant(String value) {
		// TODO Auto-generated method stub
		return repository.findByIdentifiant(value);
	}

	boolean isNumber(String value) {
		try {
			Long id = Long.parseLong(value);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Utilisateur getById(Long id) {
		return repository.findByIdUtilisateur(id);
	}

	@Override
	public Utilisateur getByPhone(String phone) {
		return repository.findByPhone(phone);
	}
}

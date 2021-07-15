package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Pharmacie;
import mg.meddoc.repositories.PharmacieRepository;


@Service
public class PharmacieImplementation implements PharmacieService {
	
	@Autowired
	private PharmacieRepository repository;

	@Override
	public Pharmacie save(Pharmacie entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Pharmacie> saveAll(List<Pharmacie> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Pharmacie getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((Long) id).get();
	}

	@Override
	public List<Pharmacie> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Pharmacie> getAllPageable(int page, int max, String col, String direction) {
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
	public Pharmacie recherchePharmacie(String raisonSocial) {
		return repository.recherchePharmacie(raisonSocial);
	}

	@Override
	public Page<Pharmacie> findByRaisonSocialContainingIgnoreCase(String raisonSocial, int page, int size, String sort,
			String direction) {
		if(direction.compareToIgnoreCase("asc")==0||direction.compareToIgnoreCase("ascending")==0)
			return repository.findByRaisonSocialContainingIgnoreCase(raisonSocial, PageRequest.of((page-1), size, Direction.ASC, sort));
		else
			return repository.findByRaisonSocialContainingIgnoreCase(raisonSocial, PageRequest.of((page-1), size, Direction.DESC, sort));
	}
	
	//@Override
	//public void stateDeleteById(Serializable id, Serializable idStatut) {
		// TODO Auto-generated method stub
	//repository.modifierStatutByStatut((Long)id, (Long)idStatut);
	//}
	
	
}

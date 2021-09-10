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
		return repository.save(entity);
	}

	@Override
	public List<Pharmacie> saveAll(List<Pharmacie> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public Pharmacie getById(Serializable id) {
		return repository.findById((Long) id).get();
	}

	@Override
	public List<Pharmacie> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<Pharmacie> getAllPageable(int page, int max, String col, String direction) {
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		repository.deleteById((Long)id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
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

	@Override
	public List<Pharmacie> findByUtilisateursIdUtilisateur(Long id) {
		return repository.findByUtilisateursIdUtilisateur(id);
	}

	@Override
	public Pharmacie getByRaisonSocial(String raisonSocial) {
		return repository.findByRaisonSocial(raisonSocial);
	}

	@Override
	public Pharmacie getPharmacieById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Long getNextSeq() {
		return repository.getNextSeq();
	}

	@Override
	public Pharmacie findByRaisonSocialAndAdresseDistrictNomDistrict(String raisonSocial, String nomDistrict) {
		return repository.findByRaisonSocialAndAdresseDistrictNomDistrict(raisonSocial, nomDistrict);
	}

	@Override
	public List<Pharmacie> findByDoClickAndCollect() {
		return repository.findByDoClickandCollectTrue();
	}
	
}

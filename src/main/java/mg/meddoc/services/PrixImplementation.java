package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Prix;
import mg.meddoc.models.PrixPK;
import mg.meddoc.repositories.PrixRepository;

@Service
public class PrixImplementation implements PrixService{
	
	@Autowired
	private PrixRepository repository;
	
	@Override
	public Prix save(Prix entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Prix> saveAll(List<Prix> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Prix getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((PrixPK) id).get();
	}

	@Override
	public List<Prix> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Prix> getAllPageable(int page, int max, String col, String direction) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		repository.deleteById((PrixPK)id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {	
	}

	@Override
	public Prix getProductPrice(Long id) {
//		return repository.findByIdProduit(id);
		return null;
	}

	@Override
	public Prix getPrixByIdProduitAndIdPharmacie(Long idProduit, long idPharmacie) {
		// TODO Auto-generated method stub
		return repository.findPrixByIdProduitAndIdPharmacie(idProduit, idPharmacie);
	}

	@Override
	public Prix getPrixByIdPharmacie(Long idPharmacie) {
		return repository.findByIdPharmacie(idPharmacie);
	}

	@Override
	public List<Prix> findByIdProduit(Long prix) {
		// TODO Auto-generated method stub
		return repository.findByIdProduit(prix);
	}

}

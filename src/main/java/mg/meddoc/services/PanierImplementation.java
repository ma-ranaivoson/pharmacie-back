package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Panier;
import mg.meddoc.models.PanierPK;
import mg.meddoc.repositories.PanierRepository;

@Service
public class PanierImplementation implements PanierService{
	
	@Autowired
	private PanierRepository repository;
	
	@Override
	public Panier save(Panier entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Panier> saveAll(List<Panier> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Panier getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((PanierPK) id).get();
	}

	@Override
	public List<Panier> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Panier> getAllPageable(int page, int max, String col, String direction) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		repository.deleteById((PanierPK)id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Panier> getPanierNotPaid(Long id) {
		return repository.findByIdUtilisateurAndIdPaiementIsNull(id);
	}

	@Override
	public List<Panier> getUserCart(Long id) {
		return repository.findByIdUtilisateur(id);
	}

	@Override
	public Panier getCartByIdProduct(Long idProduct, Long idPharmacie ,Long idUser) {
		return repository.findByIdProduitAndIdPharmacieAndIdUtilisateur(idProduct, idPharmacie ,idUser);
	}
}

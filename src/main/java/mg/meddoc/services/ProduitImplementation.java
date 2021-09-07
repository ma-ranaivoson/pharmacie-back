package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Pharmacie;
import mg.meddoc.models.Produit;
import mg.meddoc.repositories.ProduitRepository;

@Service
public class ProduitImplementation implements ProduitService {

	@Autowired
	private ProduitRepository repository;

	@Override
	public Produit save(Produit entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Produit> saveAll(List<Produit> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Produit getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((Long) id).get();
	}

	@Override
	public List<Produit> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Produit> getAllPageable(int page, int max, String col, String direction) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if (direction.trim().compareToIgnoreCase("desc") == 0
				|| direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		repository.deleteById((Long) id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produit rechercheProduit(String designation) {
		// TODO Auto-generated method stub
		return repository.rechercheProduit(designation);
	}

	@Override
	public Page<Produit> findByDesignationContainingIgnoreCase(String designation, int page, int size,
			String columnSort, String direction) {
		if (direction == null || columnSort == null)
			return repository.findByDesignationContainingIgnoreCase(designation, PageRequest.of((page - 1), size));
		if (direction.compareToIgnoreCase("asc") == 0 || direction.compareToIgnoreCase("ascending") == 0)
			return repository.findByDesignationContainingIgnoreCase(designation,
					PageRequest.of((page - 1), size, Direction.ASC, columnSort));
		else
			return repository.findByDesignationContainingIgnoreCase(designation,
					PageRequest.of((page - 1), size, Direction.DESC, columnSort));
	}

	@Override
	public Page<Produit> getAllProductByMarque(String nomination, int page, int size, String direction, String sort) {
		// No direction and no input
		if (direction == null || sort == null)
			return repository.findByMarqueNomination(nomination, PageRequest.of((page - 1), size));

		// If direction is ascending
		if (direction.compareToIgnoreCase("asc") == 0 || direction.compareToIgnoreCase("ascending") == 0)
			return repository.findByMarqueNomination(nomination, PageRequest.of((page - 1), size, Direction.ASC, sort));
		else
			return repository.findByMarqueNomination(nomination, PageRequest.of((page - 1), size, Direction.DESC, sort));

	}

	@Override
	public Page<Produit> getAllProductPage(int page, int size, String direction, String sort) {
		if (direction.compareToIgnoreCase("asc") == 0 || direction.compareToIgnoreCase("ascending") == 0)
			return repository.findAll(PageRequest.of((page - 1), size, Direction.ASC, sort));
		else
			return repository.findAll(PageRequest.of((page-1), size, Direction.DESC, sort));		
	}

	@Override
	public Page<Produit> getAllProductBySousCategorie(Long idSousCategorie, int page, int size, String direction,
			String sort) {
		if(direction.compareTo("asc")==0 || direction.compareToIgnoreCase("ascending")==0)
			return repository.findByCategorieIdSouCategorie(idSousCategorie, PageRequest.of((page-1), size, Direction.ASC, sort));
		else
			return repository.findByCategorieIdSouCategorie(idSousCategorie, PageRequest.of((page-1), size, Direction.DESC, sort));
	}

	@Override
	public Page<Produit> getAllProductByCategorie(Long idCategorie, int page, int size, String direction, String sort) {
		if(direction.compareTo("asc")==0 || direction.compareToIgnoreCase("ascending")==0)
			return repository.findByCategorieIdCategorie(idCategorie, PageRequest.of((page -1), size, Direction.ASC, sort));
		else
			return repository.findByCategorieIdCategorie(idCategorie, PageRequest.of((page -1), size, Direction.DESC, sort));
	}

	@Override
	public Produit getProductById(Long id) {
		return repository.findByIdProduit(id);
	}

	@Override
	public List<Pharmacie> findByPharmacieIdPharmacie(Long id) {
		return repository.findByPharmacieIdPharmacie(id);
	}

	@Override
	public List<Pharmacie> findByPharmacieIdProduit(Long id) {
		return repository.findByPharmacieIdProduit(id);
	}
}

package mg.meddoc.services;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

//import mg.meddoc.models.adresses.Fokontany;
//import mg.meddoc.repositories.adresses.FokontanyRep;
import mg.meddoc.models.*;
import mg.meddoc.repositories.*;

@Service
public class FokontanySerImp implements FokontanySer {
	
	@Autowired
	private FokontanyRep repository;

	@Override
	public Fokontany save(Fokontany entity) {
		return repository.save(entity);
	}

	@Override
	public List<Fokontany> saveAll(List<Fokontany> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public Fokontany getById(Serializable id) {
		return repository.findById((Integer) id).get();
	}

	@Override
	public List<Fokontany> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<Fokontany> getAllPageable(int page, int max, String col, String direction) {
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		repository.deleteById((Integer) id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		repository.modifierStatutByStatut((Long)id, (Long)idStatut);
		
	}
	
	@Override
	public List<Fokontany> findByArrondissementIdArrondissement(Long idArrondissement) {
		return repository.findByArrondissementIdArrondissement(idArrondissement);
	}

	@Override
	public List<Fokontany> rechercheLieu(String value) {
		return repository.rechercheLieu(value);
	}

	@Override
	public List<Fokontany> findByNomFokontanyLike(String fokontany) {
		return repository.findByNomFokontanyLike("%"+fokontany+"%");
	}

//	@Override
//	public List<Fokontany> findByArrondissementNomArrondissementContainsOrArrondissementCommuneNomCommuneContainsOrArrondissementCommuneDistrictNomDistrictContainsOrArrondissementCommuneDistrictRegionNomRegionContainsOrArrondissementCommuneDistrictRegionProvinceNomProvinceContains(
//			String valeur) {
//		return repository.findByArrondissementNomArrondissementContainsOrArrondissementCommuneNomCommuneContainsOrArrondissementCommuneDistrictNomDistrictContainsOrArrondissementCommuneDistrictRegionNomRegionContainsOrArrondissementCommuneDistrictRegionProvinceNomProvinceContains(valeur);
//	}

}
package mg.meddoc.services;
import java.util.List;
//import mg.meddoc.models.adresses.Fokontany;
import mg.meddoc.models.*;
import mg.meddoc.services.CRUDService;

public interface FokontanySer extends CRUDService<Fokontany> {

	List<Fokontany> findByArrondissementIdArrondissement(Long idArrondissement);
		
//	List<Fokontany> findByArrondissementNomArrondissementContainsOrArrondissementCommuneNomCommuneContainsOrArrondissementCommuneDistrictNomDistrictContainsOrArrondissementCommuneDistrictRegionNomRegionContainsOrArrondissementCommuneDistrictRegionProvinceNomProvinceContains(String valeur);

	List<Fokontany> rechercheLieu(String value);
	
	List<Fokontany> findByNomFokontanyLike(String fokontany);
}

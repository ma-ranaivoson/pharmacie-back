package mg.meddoc.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import mg.meddoc.models.adresses.Fokontany;
import mg.meddoc.models.*;

public interface FokontanyRep extends JpaRepository<Fokontany, Integer> {
	
	@Query(nativeQuery=true,value="UPDATE fokontany SET id_statut = ?2 WHERE id_fokontany = ?1")
	void modifierStatutByStatut(Long id, Long idStatut);
	
	List<Fokontany> findByArrondissementIdArrondissement(Long idArrondissement);
	
//	List<Fokontany> findByArrondissementNomArrondissementContainsOrArrondissementCommuneNomCommuneContainsOrArrondissementCommuneDistrictNomDistrictContainsOrArrondissementCommuneDistrictRegionNomRegionContainsOrArrondissementCommuneDistrictRegionProvinceNomProvinceContains(String valeur);

	@Query(nativeQuery=true,value="SELECT DISTINCT f.* FROM fokontany f JOIN arrondissement a ON f.id_arrondissement=a.id_arrondissement"
			+ " JOIN commune c ON a.id_commune=c.id_commune JOIN district d ON c.id_district=d.id_district"
			+ " JOIN region r ON d.id_region=r.id_region JOIN province p ON r.id_province=p.id_province"
			+ " WHERE UPPER(f.nom_fokontany) LIKE '%'||UPPER(?1)||'%' OR  UPPER(a.nom_arrondissement) LIKE '%'||UPPER(?1)||'%'"
			+ " OR UPPER(c.nom_commune) LIKE '%'||UPPER(?1)||'%' OR UPPER(d.nom_district) LIKE '%'||UPPER(?1)||'%'"
			+ " OR UPPER(r.nom_region) LIKE '%'||UPPER(?1)||'%' OR UPPER(p.nom_province) LIKE '%'||UPPER(?1)||'%'")
	List<Fokontany> rechercheLieu(String value);
	
	List<Fokontany> findByNomFokontanyLike(String fokontany);
}

package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.TypeUtilisateur;

public interface Type_UtilisateurRepository extends JpaRepository<TypeUtilisateur, Long>{
	@Query(nativeQuery=true,value="SELECT type_utilisateur.* FROM type_utilisateur WHERE libelle=?1")
	TypeUtilisateur rechercheType_Utilisateur(String libelle);
}

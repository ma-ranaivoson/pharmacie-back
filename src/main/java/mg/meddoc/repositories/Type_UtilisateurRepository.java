package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Type_Utilisateur;

public interface Type_UtilisateurRepository extends JpaRepository<Type_Utilisateur, Long>{
	@Query(nativeQuery=true,value="SELECT type_utilisateur.* FROM type_utilisateur WHERE libelle=?1")
	Type_Utilisateur rechercheType_Utilisateur(String libelle);
}

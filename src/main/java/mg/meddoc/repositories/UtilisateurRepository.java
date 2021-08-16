package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	@Query(nativeQuery=true,value="SELECT utiliisateur.* FROM utilisateur WHERE nom=?1")
	Utilisateur rechercheUtilisateur(String nom);
	
	//Optional<Utilisateur> findByUsername(String username);
    //Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
	
	Utilisateur findByEmail(String email);
	
	Boolean existsByPhone(String phone);
	
	Utilisateur findByPhone(String phone);
	
	@Query(nativeQuery=true,value="SELECT distinct utilisateur.* FROM utilisateur WHERE phone=?1 or email=?1 or id_utilisateur = CAST(?1 AS BIGINT)")
	Utilisateur findByIdentifiant(String value);
	
	Utilisateur findByIdUtilisateur(Long id);
	
}

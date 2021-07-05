package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	@Query(nativeQuery=true,value="SELECT utilisateur.* FROM utilisateur WHERE nom=?1")
	Utilisateur rechercheUtilisateur(String nom);
}

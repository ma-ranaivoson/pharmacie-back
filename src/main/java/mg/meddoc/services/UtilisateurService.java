package mg.meddoc.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import mg.meddoc.models.Utilisateur;

public interface UtilisateurService extends CRUDService<Utilisateur>, UserDetailsService{
	Utilisateur rechercheUtilisateur(String nom);

	Boolean existsByAdresse(String adresse);
	
	Utilisateur findByAdresse(String adresse);
	
}

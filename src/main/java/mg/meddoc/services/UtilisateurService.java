package mg.meddoc.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import mg.meddoc.models.Utilisateur;

public interface UtilisateurService extends CRUDService<Utilisateur>, UserDetailsService{
	Utilisateur rechercheUtilisateur(String nom);
	Boolean existsByEmail(String email);
	Utilisateur findByEmail(String email);	
	Boolean existsByPhone(String phone);	
	Utilisateur findByPhone(String phone);
	Utilisateur findByIdentifiant(String value);
	Utilisateur getById(Long id);
	Utilisateur getByPhone(String phone);
}

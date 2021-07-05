package mg.meddoc.services;

import mg.meddoc.models.Utilisateur;

public interface UtilisateurService extends CRUDService<Utilisateur>{
	Utilisateur rechercheUtilisateur(String nom);
}

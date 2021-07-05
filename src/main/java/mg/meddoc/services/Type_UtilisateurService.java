package mg.meddoc.services;

import mg.meddoc.models.Type_Utilisateur;

public interface Type_UtilisateurService extends CRUDService<Type_Utilisateur>{
	Type_Utilisateur rechercheType_Utilisateur(String libelle);
}

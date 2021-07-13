package mg.meddoc.services;

import mg.meddoc.models.TypeUtilisateur;

public interface Type_UtilisateurService extends CRUDService<TypeUtilisateur>{
	TypeUtilisateur rechercheType_Utilisateur(String libelle);
}

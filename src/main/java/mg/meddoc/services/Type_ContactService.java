package mg.meddoc.services;

import mg.meddoc.models.Type_Contact;

public interface Type_ContactService extends CRUDService<Type_Contact>{
	Type_Contact rechercheType_Contact(String libelle);
}

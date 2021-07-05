package mg.meddoc.services;

import mg.meddoc.models.Contact;

public interface ContactService extends CRUDService<Contact>{
	Contact rechercheContact(String valeur);
}

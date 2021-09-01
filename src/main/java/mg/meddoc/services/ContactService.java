package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.Contact;

public interface ContactService extends CRUDService<Contact>{
	Contact rechercheContact(String valeur);
	
	List<Contact> findByIdEntiteAndTypeContactIdTypeContact(Long id, Integer idType);

	List<Contact> findByIdEntite(Long id);
	
	List<Contact> findByPharmacieIdPharmacieAndTypeContactIdTypeContact(Long id, Integer idTypeContact);
}

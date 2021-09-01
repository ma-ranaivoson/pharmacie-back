package mg.meddoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Contact;
import mg.meddoc.models.ContactPK;

public interface ContactRepository extends JpaRepository<Contact, ContactPK>{
	@Query(nativeQuery=true,value="SELECT contact.* FROM contact WHERE valeur=?1")
	Contact rechercheContact(String valeur);
	
	List<Contact> findByIdEntiteAndTypeContactIdTypeContact(Long id, Integer idType);

	List<Contact> findByIdEntite(Long id);
	
	// 	SELECT valeur FROM contact 
	//	JOIN table.Pharmacie
	//	WHERE IdPharmacie=Long id 
	//	AND idTypeContact=0 ou 1

	List<Contact> findByPharmacieIdPharmacieAndTypeContactIdTypeContact(Long id, Integer idTypeContact);
	
	//SELECT * FROM contact  ==	findByContact
	//SELECT * FROM contact WHERE valeur=rakotobe@gmail.com	==	findbyPharmacie(String valeur)
	
	
	
}

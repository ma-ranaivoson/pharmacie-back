package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import mg.meddoc.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	@Query(nativeQuery=true,value="SELECT contact.* FROM contact WHERE valeur=?1")
	Contact rechercheContact(String valeur);
}

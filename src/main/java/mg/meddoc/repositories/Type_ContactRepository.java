package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.meddoc.models.Type_Contact;

public interface Type_ContactRepository extends JpaRepository<Type_Contact, Long>{
	@Query(nativeQuery=true,value="SELECT type_ontact.* FROM type_ontact WHERE libelle=?1")
	Type_Contact rechercheType_Contact(String libelle);
}

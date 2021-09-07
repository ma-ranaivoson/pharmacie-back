package mg.meddoc.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.UserModePaiement;
import mg.meddoc.models.UserModePaiementPK;

public interface UserModePaiementRepository extends JpaRepository<UserModePaiement, UserModePaiementPK>{
	List<UserModePaiement> findByIdUtilisateur(Long id);
}

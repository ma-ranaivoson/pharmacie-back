package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.UserModePaiement;

public interface UserModePaiementService extends CRUDService<mg.meddoc.models.UserModePaiement>{
	List<UserModePaiement> findByIdUtilisateur(Long id);
}

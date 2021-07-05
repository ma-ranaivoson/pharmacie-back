package mg.meddoc.services;

import mg.meddoc.models.Service;

public interface ServiceService extends CRUDService<Service>{
	Service recherchePharmacie(String libelle);
}

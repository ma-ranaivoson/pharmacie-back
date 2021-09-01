package mg.meddoc.services;

import java.util.List;

import mg.meddoc.models.Service;

public interface ServiceService extends CRUDService<Service>{
	Service recherchePharmacie(String libelle);

}

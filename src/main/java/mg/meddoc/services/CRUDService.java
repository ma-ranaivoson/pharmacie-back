package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public interface CRUDService<E> {

	E save(E entity);
	
	List<E> saveAll(List<E> entities);

	E getById(Serializable id);
	
	List<E> getAll();
	
	Page<E> getAllPageable(int page, int max, String col, String direction);

	void deleteById(Serializable id);
	
	void stateDeleteById(Serializable id, Serializable idStatut);
}

package mg.meddoc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mg.meddoc.models.Staff;
import mg.meddoc.repositories.StaffRepository;

@Service
public class StaffImplementation implements StaffService{
	
	@Autowired
	private StaffRepository repository;
	
	@Override
	public Staff save(Staff entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Staff> saveAll(List<Staff> entities) {
		// TODO Auto-generated method stub
		return repository.saveAll(entities);
	}

	@Override
	public Staff getById(Serializable id) {
		// TODO Auto-generated method stub
		return repository.findById((Long) id).get();
	}

	@Override
	public List<Staff> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Page<Staff> getAllPageable(int page, int max, String col, String direction) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(page, max, Direction.ASC, col);
		if(direction.trim().compareToIgnoreCase("desc") == 0 || direction.trim().compareToIgnoreCase("descending") == 0)
			pageRequest = PageRequest.of(page, max, Direction.DESC, col);
		return repository.findAll(pageRequest);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		repository.deleteById((Long)id);
	}

	@Override
	public void stateDeleteById(Serializable id, Serializable idStatut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Staff rechercheStaff(String nom_staf) {
		// TODO Auto-generated method stub
		return repository.rechercheStaff(nom_staf);
	}

	@Override
	public void deleteStaff(Staff staff) {
		// TODO Auto-generated method stub
		repository.delete(staff);
	}

	@Override
	public Staff findByIdStaff(Long id) {
		// TODO Auto-generated method stub
		return repository.findByIdStaff(id);
	}

}

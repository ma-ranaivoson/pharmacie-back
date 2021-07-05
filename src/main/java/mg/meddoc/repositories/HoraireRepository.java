package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.meddoc.models.Horaire;

public interface HoraireRepository extends JpaRepository<Horaire, Long>{
	
}

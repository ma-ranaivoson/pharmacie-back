package mg.meddoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.meddoc.models.ClickAndCollect;
import mg.meddoc.models.ClickAndCollectPK;


public interface ClickAndCollectRepository extends JpaRepository<ClickAndCollect, ClickAndCollectPK>{
}

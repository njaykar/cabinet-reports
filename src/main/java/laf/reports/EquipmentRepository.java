package laf.reports;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, String> {

}

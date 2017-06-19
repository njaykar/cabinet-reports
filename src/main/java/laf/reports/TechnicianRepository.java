package laf.reports;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends CrudRepository<Technician, String> {
	public List<Technician> findByTechnicianName(String technicianName);
}

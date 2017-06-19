package laf.reports;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
	public List<Client> findByClientName(String clientName);
}

package laf.reports;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends CrudRepository<Instrument, String> {
	public List<Instrument> findByInstrumentName(String instrumentName);
}
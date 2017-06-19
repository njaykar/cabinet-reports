package laf.reports;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the instrument database table.
 * 
 */
@Entity
@NamedQuery(name="Instrument.findAll", query="SELECT i FROM Instrument i")
public class Instrument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="instrument_id")
	private String instrumentId;

	@Column(name="instrument_name")
	private String instrumentName;

	@Column(name="instrument_serial_no")
	private String instrumentSerialNo;

	@Column(name="instrument_type")
	private String instrumentType;

	//bi-directional one-to-one association to CorrectionFactor
	@OneToOne(mappedBy="instrument")
	private CorrectionFactor correctionFactor;

	//bi-directional many-to-many association to Report
	@ManyToMany(mappedBy="instruments")
	private Set<Report> reports;

	public Instrument() {
	}

	public String getInstrumentId() {
		return this.instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName() {
		return this.instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getInstrumentSerialNo() {
		return this.instrumentSerialNo;
	}

	public void setInstrumentSerialNo(String instrumentSerialNo) {
		this.instrumentSerialNo = instrumentSerialNo;
	}

	public String getInstrumentType() {
		return this.instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	public CorrectionFactor getCorrectionFactor() {
		return this.correctionFactor;
	}

	public void setCorrectionFactor(CorrectionFactor correctionFactor) {
		this.correctionFactor = correctionFactor;
	}

	public Set<Report> getReports() {
		return this.reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

}
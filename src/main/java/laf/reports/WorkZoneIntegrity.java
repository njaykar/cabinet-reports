package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the work_zone_integrity database table.
 * 
 */
@Entity
@Table(name="work_zone_integrity")
@NamedQuery(name="WorkZoneIntegrity.findAll", query="SELECT w FROM WorkZoneIntegrity w")
public class WorkZoneIntegrity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="excessive_penetration_location")
	private String excessivePenetrationLocation;

	@Column(name="final_penetration_level")
	private String finalPenetrationLevel;

	//bi-directional one-to-one association to Report
	private Report report;

	public WorkZoneIntegrity() {
	}

	public String getExcessivePenetrationLocation() {
		return this.excessivePenetrationLocation;
	}

	public void setExcessivePenetrationLocation(String excessivePenetrationLocation) {
		this.excessivePenetrationLocation = excessivePenetrationLocation;
	}

	public String getFinalPenetrationLevel() {
		return this.finalPenetrationLevel;
	}

	public void setFinalPenetrationLevel(String finalPenetrationLevel) {
		this.finalPenetrationLevel = finalPenetrationLevel;
	}

	@Id
	@OneToOne
	@JoinColumn(name = "certificate_no")
	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}
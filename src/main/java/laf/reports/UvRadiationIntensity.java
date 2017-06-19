package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uv_radiation_intensity database table.
 * 
 */
@Entity
@Table(name="uv_radiation_intensity")
@NamedQuery(name="UvRadiationIntensity.findAll", query="SELECT u FROM UvRadiationIntensity u")
public class UvRadiationIntensity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="intensity_readings")
	private String intensityReadings;

	//bi-directional one-to-one association to Report
	private Report report;

	public UvRadiationIntensity() {
	}

	public String getIntensityReadings() {
		return this.intensityReadings;
	}

	public void setIntensityReadings(String intensityReadings) {
		this.intensityReadings = intensityReadings;
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
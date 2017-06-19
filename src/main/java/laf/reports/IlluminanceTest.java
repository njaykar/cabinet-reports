package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the illuminance_test database table.
 * 
 */
@Entity
@Table(name="illuminance_test")
@NamedQuery(name="IlluminanceTest.findAll", query="SELECT i FROM IlluminanceTest i")
public class IlluminanceTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="average_illuminance")
	private int averageIlluminance;

	@Column(name="illuminance_readings")
	private String illuminanceReadings;

	@Column(name="minimum_illuminance")
	private int minimumIlluminance;

	//bi-directional one-to-one association to Report
	private Report report;

	public IlluminanceTest() {
	}

	public int getAverageIlluminance() {
		return this.averageIlluminance;
	}

	public void setAverageIlluminance(int averageIlluminance) {
		this.averageIlluminance = averageIlluminance;
	}

	public String getIlluminanceReadings() {
		return this.illuminanceReadings;
	}

	public void setIlluminanceReadings(String illuminanceReadings) {
		this.illuminanceReadings = illuminanceReadings;
	}

	public int getMinimumIlluminance() {
		return this.minimumIlluminance;
	}

	public void setMinimumIlluminance(int minimumIlluminance) {
		this.minimumIlluminance = minimumIlluminance;
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
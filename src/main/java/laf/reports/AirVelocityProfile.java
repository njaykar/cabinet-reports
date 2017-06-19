package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the air_velocity_profile database table.
 * 
 */
@Entity
@Table(name="air_velocity_profile")
@NamedQuery(name="AirVelocityProfile.findAll", query="SELECT a FROM AirVelocityProfile a")
public class AirVelocityProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="correction_factor_used")
	private String correctionFactorUsed;

	@Column(name="final_average_velocity")
	private float finalAverageVelocity;

	@Column(name="final_readings")
	private String finalReadings;

	@Column(name="initial_readings")
	private String initialReadings;

	@Column(name="maximum_velocity")
	private float maximumVelocity;

	@Column(name="minimum_velocity")
	private float minimumVelocity;

	@Column(name="test_method")
	private String testMethod;

	//bi-directional one-to-one association to Report
	private Report report;

	public AirVelocityProfile() {
	}

	public String getCorrectionFactorUsed() {
		return this.correctionFactorUsed;
	}

	public void setCorrectionFactorUsed(String correctionFactorUsed) {
		this.correctionFactorUsed = correctionFactorUsed;
	}

	public float getFinalAverageVelocity() {
		return this.finalAverageVelocity;
	}

	public void setFinalAverageVelocity(float finalAverageVelocity) {
		this.finalAverageVelocity = finalAverageVelocity;
	}

	public String getFinalReadings() {
		return this.finalReadings;
	}

	public void setFinalReadings(String finalReadings) {
		this.finalReadings = finalReadings;
	}

	public String getInitialReadings() {
		return this.initialReadings;
	}

	public void setInitialReadings(String initialReadings) {
		this.initialReadings = initialReadings;
	}

	public float getMaximumVelocity() {
		return this.maximumVelocity;
	}

	public void setMaximumVelocity(float maximumVelocity) {
		this.maximumVelocity = maximumVelocity;
	}

	public float getMinimumVelocity() {
		return this.minimumVelocity;
	}

	public void setMinimumVelocity(float minimumVelocity) {
		this.minimumVelocity = minimumVelocity;
	}

	public String getTestMethod() {
		return this.testMethod;
	}

	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
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
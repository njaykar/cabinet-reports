package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the air_barrier_containment database table.
 * 
 */
@Entity
@Table(name="air_barrier_containment")
@NamedQuery(name="AirBarrierContainment.findAll", query="SELECT a FROM AirBarrierContainment a")
public class AirBarrierContainment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="exhaust_filter_velocity")
	private float exhaustFilterVelocity;

	@Column(name="failed_point")
	private int failedPoint;

	@Column(name="gauge_pressure")
	private int gaugePressure;

	@Column(name="measured_pressure")
	private int measuredPressure;

	//bi-directional one-to-one association to Report
	private Report report;

	public AirBarrierContainment() {
	}

	public float getExhaustFilterVelocity() {
		return this.exhaustFilterVelocity;
	}

	public void setExhaustFilterVelocity(float exhaustFilterVelocity) {
		this.exhaustFilterVelocity = exhaustFilterVelocity;
	}

	public int getFailedPoint() {
		return this.failedPoint;
	}

	public void setFailedPoint(int failedPoint) {
		this.failedPoint = failedPoint;
	}

	public int getGaugePressure() {
		return this.gaugePressure;
	}

	public void setGaugePressure(int gaugePressure) {
		this.gaugePressure = gaugePressure;
	}

	public int getMeasuredPressure() {
		return this.measuredPressure;
	}

	public void setMeasuredPressure(int measuredPressure) {
		this.measuredPressure = measuredPressure;
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
package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the installation_gauge_pressure database table.
 * 
 */
@Entity
@Table(name="installation_gauge_pressure")
@NamedQuery(name="InstallationGaugePressure.findAll", query="SELECT i FROM InstallationGaugePressure i")
public class InstallationGaugePressure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="exhaust_final_installation_gauge_pressure")
	private int exhaustFinalInstallationGaugePressure;

	@Column(name="exhaust_final_measured_pressure")
	private int exhaustFinalMeasuredPressure;

	@Column(name="exhaust_initial_installation_gauge_pressure")
	private int exhaustInitialInstallationGaugePressure;

	@Column(name="exhaust_initial_measured_pressure")
	private int exhaustInitialMeasuredPressure;

	@Column(name="laf_final_installation_gauge_pressure")
	private int lafFinalInstallationGaugePressure;

	@Column(name="laf_final_measured_pressure")
	private int lafFinalMeasuredPressure;

	@Column(name="laf_initial_installation_gauge_pressure")
	private int lafInitialInstallationGaugePressure;

	@Column(name="laf_initial_measured_pressure")
	private int lafInitialMeasuredPressure;

	//bi-directional one-to-one association to Report
	private Report report;

	public InstallationGaugePressure() {
	}
		
	public int getExhaustFinalInstallationGaugePressure() {
		return this.exhaustFinalInstallationGaugePressure;
	}

	public void setExhaustFinalInstallationGaugePressure(int exhaustFinalInstallationGaugePressure) {
		this.exhaustFinalInstallationGaugePressure = exhaustFinalInstallationGaugePressure;
	}

	public int getExhaustFinalMeasuredPressure() {
		return this.exhaustFinalMeasuredPressure;
	}

	public void setExhaustFinalMeasuredPressure(int exhaustFinalMeasuredPressure) {
		this.exhaustFinalMeasuredPressure = exhaustFinalMeasuredPressure;
	}

	public int getExhaustInitialInstallationGaugePressure() {
		return this.exhaustInitialInstallationGaugePressure;
	}

	public void setExhaustInitialInstallationGaugePressure(int exhaustInitialInstallationGaugePressure) {
		this.exhaustInitialInstallationGaugePressure = exhaustInitialInstallationGaugePressure;
	}

	public int getExhaustInitialMeasuredPressure() {
		return this.exhaustInitialMeasuredPressure;
	}

	public void setExhaustInitialMeasuredPressure(int exhaustInitialMeasuredPressure) {
		this.exhaustInitialMeasuredPressure = exhaustInitialMeasuredPressure;
	}

	public int getLafFinalInstallationGaugePressure() {
		return this.lafFinalInstallationGaugePressure;
	}

	public void setLafFinalInstallationGaugePressure(int lafFinalInstallationGaugePressure) {
		this.lafFinalInstallationGaugePressure = lafFinalInstallationGaugePressure;
	}

	public int getLafFinalMeasuredPressure() {
		return this.lafFinalMeasuredPressure;
	}

	public void setLafFinalMeasuredPressure(int lafFinalMeasuredPressure) {
		this.lafFinalMeasuredPressure = lafFinalMeasuredPressure;
	}

	public int getLafInitialInstallationGaugePressure() {
		return this.lafInitialInstallationGaugePressure;
	}

	public void setLafInitialInstallationGaugePressure(int lafInitialInstallationGaugePressure) {
		this.lafInitialInstallationGaugePressure = lafInitialInstallationGaugePressure;
	}

	public int getLafInitialMeasuredPressure() {
		return this.lafInitialMeasuredPressure;
	}

	public void setLafInitialMeasuredPressure(int lafInitialMeasuredPressure) {
		this.lafInitialMeasuredPressure = lafInitialMeasuredPressure;
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
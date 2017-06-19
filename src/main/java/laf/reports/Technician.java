package laf.reports;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the technician database table.
 * 
 */
@Entity
@NamedQuery(name="Technician.findAll", query="SELECT t FROM Technician t")
public class Technician implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="technician_id")
	private String technicianId;

	@Column(name="technician_email")
	private String technicianEmail;

	@Column(name="technician_name")
	private String technicianName;

	@Column(name="technician_phone")
	private String technicianPhone;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="technician")
	private Set<Report> reports;

	public Technician() {
	}

	public String getTechnicianId() {
		return this.technicianId;
	}

	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}

	public String getTechnicianEmail() {
		return this.technicianEmail;
	}

	public void setTechnicianEmail(String technicianEmail) {
		this.technicianEmail = technicianEmail;
	}

	public String getTechnicianName() {
		return this.technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}

	public String getTechnicianPhone() {
		return this.technicianPhone;
	}

	public void setTechnicianPhone(String technicianPhone) {
		this.technicianPhone = technicianPhone;
	}

	public Set<Report> getReports() {
		return this.reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setTechnician(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setTechnician(null);

		return report;
	}

}
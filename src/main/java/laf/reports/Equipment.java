package laf.reports;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the equipment database table.
 * 
 */
@Entity
@NamedQuery(name="Equipment.findAll", query="SELECT e FROM Equipment e")
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="serial_no")
	private String serialNo;

	@Column(name="equipment_type")
	private String equipmentType;

	@Column(name="manufacturer_name")
	private String manufacturerName;

	@Column(name="room_location")
	private String roomLocation;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="equipment")
	private Set<Report> reports;

	public Equipment() {
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getRoomLocation() {
		return this.roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Report> getReports() {
		return this.reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setEquipment(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setEquipment(null);

		return report;
	}

}
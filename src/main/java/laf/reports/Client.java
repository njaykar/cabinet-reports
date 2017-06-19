package laf.reports;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="client_id")
	private String clientId;	

	@Column(name="client_contact_person_name")
	private String clientContactPersonName;

	@Column(name="client_email")
	private String clientEmail;

	@Column(name="client_name")
	private String clientName;

	@Column(name="client_phone")
	private String clientPhone;
	
	//bi-directional many-to-one association to Department
	@OneToMany(mappedBy="client")
	private Set<Department> departments;

	//bi-directional many-to-one association to Equipment
	@OneToMany(mappedBy="client")
	private Set<Equipment> equipments;

	public Client() {
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getClientContactPersonName() {
		return this.clientContactPersonName;
	}

	public void setClientContactPersonName(String clientContactPersonName) {
		this.clientContactPersonName = clientContactPersonName;
	}

	public String getClientEmail() {
		return this.clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return this.clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	
	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Set<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Equipment addEquipment(Equipment equipment) {
		getEquipments().add(equipment);
		equipment.setClient(this);

		return equipment;
	}

	public Equipment removeEquipment(Equipment equipment) {
		getEquipments().remove(equipment);
		equipment.setClient(null);

		return equipment;
	}
	
	public boolean hasDepartment(Department department) {
		for (Department containedDepartment : getDepartments()) {
			if (containedDepartment.getDepartmentId().equals(department.getDepartmentId())) {
				return true;
			}
		}
		return false;
	}	

}
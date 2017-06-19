package laf.reports;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Embedded
	@EmbeddedId
	@AttributeOverrides({@AttributeOverride(name = "departmentName", column = @Column(name = "department_name")),
		@AttributeOverride(name = "departmentLocation", column = @Column(name = "department_location"))})
	private DepartmentId departmentId;
	
	@Column(name = "lab_manager")
	private String labManager;
	
	@Column(name = "department_address")
	private String departmentAddress;
	
	//bi-directional many-to-one association to Client
	@ManyToOne	
	@JoinColumn(name="client_client_id")
	private Client client;
	
	public Department() {
		
	}
	
	public DepartmentId getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(DepartmentId departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getLabManager() {
		return labManager;
	}
	
	public void setLabManager(String labManager) {
		this.labManager = labManager;
	}
	
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}

package laf.reports;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class DepartmentId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="department_name")
	private String departmentName;	
	
	@Column(name="department_location")
	private String departmentLocation;
	
	public DepartmentId() {
		
	}
	
	public DepartmentId(String departmentName, String departmentLocation) {
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	
	@Override
	public boolean equals(Object obj) {
	       if (! (obj instanceof DepartmentId) ) return false;

	       final DepartmentId other = (DepartmentId) obj;
	       if (!(departmentName.equalsIgnoreCase(other.departmentName)  && departmentLocation.equalsIgnoreCase(other.departmentLocation)))
	           return false;	       
	       
	       return true;
	   }
 
}

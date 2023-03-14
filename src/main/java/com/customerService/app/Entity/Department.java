package com.customerService.app.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/************************************************************************************
 * @author        Siva Sai Mounika Penneru
 
 * Description    It is a Department Entity class which is a POJO class i.e it has only 
                  data Members,Constructors,and their respective Getters and Setters.
                  No Business Logic is there in this class.
 *Version         1.0                
 *Created Date    09-FEB-2023
 ************************************************************************************/
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentId;
	private String departmentName;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Operator> operatorList = new ArrayList<>();
	
	public Department() {
		super();
	}
	public Department(Integer departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Operator> getOperatorList() {
		return operatorList;
	}
	public void setOperatorList(List<Operator> operatorList) {
		this.operatorList = operatorList;
	}
	
}

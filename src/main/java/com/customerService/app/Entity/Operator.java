package com.customerService.app.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/************************************************************************************
 * @author        Likhitha Geddam
 
 * Description    It is a Operator Entity class which is a POJO (Plain Old Java Object) class i.e it has only 
                  data Members,Constructors,and their respective Getters and Setters.
                  No Business Logic is there in this class.
 *Version         1.0                
 *Created Date    09-FEB-2023
 ************************************************************************************/
@Entity
public class Operator {
	@Id
	@GeneratedValue
	private Integer operatorId;
	@NotBlank(message = "FirstName is Mandatory")
	@Pattern(regexp = "[a-zA-Z]{3,}", message = "First Name must have minimum 3 Characters and No Special Characters Allowed")
	private String firstName;
	private String lastName;
	@NotBlank(message = "Email is Mandatory")
	@Email(message = "Invalid Email")
	private String email;
	@NotNull
	@Size(min = 10, message = "Mobile must have at least 10 Characters")
	private String mobile;
	private String city;
	private String departmentName;
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Issue> issueList = new ArrayList<>();
	
	public Operator() {
		super();
	}
	public Operator(Integer operatorId, String firstName, String lastName, String email, String mobile, String city, String departmentName, String password) {
		super();
		this.operatorId = operatorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.departmentName = departmentName;
		this.password=password;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public List<Issue> getIssueList() {
		return issueList;
	}
	public void setIssueList(List<Issue> issueList) {
		this.issueList = issueList;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

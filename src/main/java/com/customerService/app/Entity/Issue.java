package com.customerService.app.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

/************************************************************************************
 * @author        Sameeksha Pisariwar
 
 * Description    It is a Issue Entity class which is a POJO class i.e it has only 
                  data Members,Constructors,and their respective Getters and Setters.
                  No Business Logic is there in this class.
 *Version         1.0                
 *Created Date    09-FEB-2023
 ************************************************************************************/
@Entity
public class Issue {
	
	@Id
	@GeneratedValue
	private Integer issueId;
	@NotBlank(message = "Issue Type is mandatory!")
	private String issueType;
	@NotBlank(message = "Issue description is mandatory!")
	private String issuedescription;
	@NotBlank(message = "Issue Status is mandatory!")
	private String issueStatus;
	private LocalDate issueDate;
	private String solution;
	
	public Issue() {
		super();
	}
	
	public Issue(Integer issueId, String issueType, String issuedescription, String issueStatus, LocalDate issueDate, String solution) {
		super();
		this.issueId = issueId;
		this.issueType = issueType;
		this.issuedescription = issuedescription;
		this.issueStatus = issueStatus;
		this.issueDate = issueDate;
		this.solution = solution;
	}
	
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	
	public String getIssuedescription() {
		return issuedescription;
	}
	public void setIssuedescription(String issuedescription) {
		this.issuedescription = issuedescription;
	}
	
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}
	

}

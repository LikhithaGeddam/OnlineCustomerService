package com.customerService.app.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerService.app.Entity.Issue;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Exception.IssueException;
import com.customerService.app.Exception.OperatorIdNotFoundException;
import com.customerService.app.Service.CustomerService;
import com.customerService.app.Service.IssueService;
import com.customerService.app.Service.OperatorService;

/************************************************************************************
 * @author        Sameeksha Pisariwar
 
 * Description    It is a Issue Controller class where basically the flow of the data is controlled. 
                  It controls the data flow into model object and updates the view whenever data changes.
                  
 *Version         1.0                
 *Created Date    12-FEB-2023
 ************************************************************************************/
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class IssueController {
	
	@Autowired
	private IssueService issueService;
	
	@Autowired 
	private CustomerService customerService;
	
	@Autowired
	private OperatorService operatorService;
	
	
	@PostMapping("/issue/{customerId}/")
	public String addIssue(@Valid @RequestBody Issue newIssue, @PathVariable("customerId") Integer customerId) throws CustomerException 
	{
		issueService.addIssueByCustomerId(newIssue, customerId);
		return "Details of issue Id: "+newIssue.getIssueId()+" added successfully";
	}
	
	
	@GetMapping("/issue/{issueId}/")
	public Issue getIssueByIssueId(@PathVariable("issueId") Integer issueId) throws IssueException 
	{
			return issueService.getIssueById(issueId);
		
	}
	
	
	@PutMapping("/issue/{issueid}")
	public String updateIssueById(@Valid @PathVariable("issueid") Integer issueId, @RequestBody Issue updateIssue) throws IssueException
	{
		Issue newIssue =  issueService.updateCustomerIssueById(issueId, updateIssue);
		return "Details of issue Id: "+newIssue.getIssueId()+" updated successfully";
	}
	
	
	@GetMapping("/issues")
	public List<Issue> getListOfIssues()
	{
			return issueService.getAllIssues();
	}
	
	@GetMapping("/issues/{customerId}")
	public List<Issue> getAllIssuesOfCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException, IssueException{
		
		return issueService.getAllIssuesOfCustomerById(customerId);
	}
	
	@GetMapping("issue/{issueType}/{issueStatus}")
	public List<Issue> getIssuesByTypeAndStatus(@PathVariable ("issueType") String issueType, @PathVariable("issueStatus") String issueStatus)throws IssueException{
		return issueService.getIssuesByTypeAndStatus(issueType,issueStatus);
	}
}
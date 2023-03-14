package com.customerService.app.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerService.app.Entity.Customer;
import com.customerService.app.Entity.Department;
import com.customerService.app.Entity.Issue;
import com.customerService.app.Entity.Operator;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Exception.DepartmentIdNotFoundException;
import com.customerService.app.Exception.IssueException;
import com.customerService.app.Repository.CustomerRepository;
import com.customerService.app.Repository.IssueRepository;

/************************************************************************************
 * @author        Pisariwar Sameeksha
 
 * Description    It is a Service class that provides the service methods for adding a new Issue, 
                  Updating existing Issue details ,Fetching Details of a Issue by issue Id,
                  Fetching all Issue Details, Assigning Issue to Operator By Id.
                  
 *Version         1.0 
                
 *Created Date    09-FEB-2023
 ************************************************************************************/
@Service
public class IssueServiceImplementation implements IssueService{
	
	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Issue addIssueByCustomerId(Issue newIssue, Integer customerId) throws CustomerException {
		
		Optional<Customer> optCustomer = this.customerRepository.findById(customerId);
		if(optCustomer.isEmpty()) {
			throw new CustomerException("!!! Department Id "+customerId+" Does Not Exist !!!");
		}
		Customer foundCustomer = optCustomer.get();
		Issue addIssue = this.issueRepository.save(newIssue);
		foundCustomer.getIssueList().add(newIssue);
		this.customerRepository.save(foundCustomer);
		return addIssue;
	}
	

	@Override
	public Issue getIssueById(Integer IssueId) throws IssueException {
		Optional<Issue> optIssue = issueRepository.findById(IssueId);
		if(optIssue.isEmpty()) {
			throw new IssueException("Issue Id Not Found");
		}
		return optIssue.get();
		
	}

	@Override
	public Issue updateCustomerIssueById(Integer issueId, Issue issue) throws IssueException{
		Optional<Issue> optIssue = issueRepository.findById(issue.getIssueId());
		if(optIssue.isEmpty()) {
			throw new IssueException("Invalid Issue details");
		}
		return issueRepository.save(issue);
	}
	

	@Override
	public List<Issue> getAllIssues() {
		return this.issueRepository.findAll();
	}

	
	@Override
	public List<Issue> getAllIssuesOfCustomerById(Integer customerId) throws CustomerException, IssueException {
		Optional<Customer> optCustomer = customerRepository.findById(customerId);
		if(optCustomer.isEmpty()) {
			throw new CustomerException("ID Not Found");
		}
		if(optCustomer.get().getIssueList().isEmpty()) {
			throw new IssueException("Issue Details Not Found");
		}
		return optCustomer.get().getIssueList();
	}
	
	
	@Override
	public List<Issue> getIssuesByTypeAndStatus(String issueType, String issueStatus) throws IssueException {
		List<Issue> issueList1=issueRepository.findByIssueType(issueType);
		List<Issue> issueList2=new ArrayList<>();
		for(int i=0;i<issueList1.size();i++) {
			String status=issueList1.get(i).getIssueStatus();
			if(status.equals(issueStatus)) {
				issueList2.add(issueList1.get(i));
			}
		}
		return issueList2;
	}

}

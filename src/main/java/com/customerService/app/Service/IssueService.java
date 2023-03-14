package com.customerService.app.Service;

import java.util.List;

import com.customerService.app.Entity.Issue;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Exception.IssueException;
import com.customerService.app.Exception.OperatorIdNotFoundException;

public interface IssueService {
	
	Issue addIssueByCustomerId(Issue newIssue, Integer customerId) throws CustomerException;
	
	Issue updateCustomerIssueById(Integer issueId, Issue issue) throws IssueException;
	
	Issue getIssueById(Integer IssueId) throws IssueException;
	
	List<Issue> getAllIssues() ;
	
	List<Issue> getAllIssuesOfCustomerById(Integer customerId) throws CustomerException, IssueException;
	
	List<Issue> getIssuesByTypeAndStatus(String issueType, String issueStatus) throws IssueException;

}

package com.customerService.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerService.app.Entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findByEmail(String email);
	
	Customer findByMobileNumber(String mobileNumber);

}

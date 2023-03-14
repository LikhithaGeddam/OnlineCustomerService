package com.customerService.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerService.app.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Admin findByEmail(String email);
	
	Admin findByName(String name);
	
	Admin deleteByName(String adminName);

}

package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	

	boolean existsByEmail(String email);

	Users getByEmail(String email);
	
	 
}


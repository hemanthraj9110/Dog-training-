package com.dogtraining.DogTraining.Register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.dogtraining.DogTraining.Register.dto.Admin;

@RestController
public interface  AdminRepository extends JpaRepository<Admin,Integer>{

	Admin findByPhoneNumber(long phoneNumber);
			

	
}
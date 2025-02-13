package com.dogtraining.DogTraining.Register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dogtraining.DogTraining.Register.dto.User;

@Repository
public interface  RegisterRepository extends JpaRepository<User,Integer>{

	
	User findByPhoneNumber(long phoneNumber);
	User findByEmail(String email);

}



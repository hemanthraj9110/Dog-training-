package com.dogtraining.DogTraining.Register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtraining.DogTraining.Register.dto.User;
import com.dogtraining.DogTraining.Register.repository.RegisterRepository;
@Service
public class RegisterService {
		@Autowired
		private RegisterRepository repository;
		
		//save register details
		public String registerservice(User l) {
			
			if(null!=fetchByphoneNumber(l.getPhoneNumber())||fetchByEmail(l.getEmail())!=null){
				return "phone number or email  already exist";
			}
			repository.save(l);
				return "data saved";
			
		}
		

		//get all login details
		public Object getRegisterdDetails() {
		
			if (repository.findAll()==null) {
				return "no data to display";
			}
			
			return repository.findAll();
		}
		
		//fetch by --phone number
		public User fetchByphoneNumber(long phoneNumber) {
			return repository.findByPhoneNumber(phoneNumber);
		}
		
		//fetch by --email
		private User fetchByEmail(String email) {
			return repository.findByEmail(email);
		}
		
		//update user email
		public String updateEmail(long phoneNumber,String email) {
				User u=fetchByphoneNumber(phoneNumber);
				if(u!=null) {
					u.setEmail(email);
					repository.save(u);
				return "User Email updated";
				}
					return "No phoneNumber to update user";
				}
				
}

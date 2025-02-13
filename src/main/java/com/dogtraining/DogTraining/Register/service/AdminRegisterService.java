package com.dogtraining.DogTraining.Register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dogtraining.DogTraining.Register.dto.Admin;
import com.dogtraining.DogTraining.Register.dto.User;
import com.dogtraining.DogTraining.Register.repository.AdminRepository;
import com.dogtraining.DogTraining.Register.repository.RegisterRepository;

@Service
public class AdminRegisterService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private RegisterRepository repository;
	
	//save admin detail
	public String registerservice(Admin l) {
		
		if(null!=fetchByphoneNumber(l.getPhoneNumber())){
			return "phone number already exist";
		}
		adminRepository.save(l);
			return "data saved";
		
		}
	
	
		//get all admin detail
		public Object getRegisterdAdminDetails() {
		
		if (adminRepository.findAll()==null) {
			return "no admin data to display";
		}
		return adminRepository.findAll();
		}
		
		
		
		//get all user detail 
		public Object getRegisterdUserDetails() {
			if (repository.findAll()==null) {
				return "no data to display";
			}
			return repository.findAll();
			}

		
		
		//find admin by phno in admin login
		public Admin fetchByAdminphoneNumber(long phoneNumber) {
			return adminRepository.findByPhoneNumber(phoneNumber);
		}
		
		
		
		
		//find user by phno in admin login
		public User fetchByphoneNumber( long phoneNumber) {
			return repository.findByPhoneNumber(phoneNumber);
		}
		
		
		
		//update admin email
		public String updateAdminEmail(long phoneNumber,String email) {
			Admin a=fetchByAdminphoneNumber(phoneNumber);
			if(a!=null) {
				a.setEmail(email);
				adminRepository.save(a);
				return "Email updated";
			}
			return "No phoneNumber to update";
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

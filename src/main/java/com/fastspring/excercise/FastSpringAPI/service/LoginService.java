package com.fastspring.excercise.FastSpringAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.LoginPerson;
import com.fastspring.excercise.FastSpringAPI.repository.ILoginPersonRepo;

@Service
public class LoginService {
	
	@Autowired
	ILoginPersonRepo userRepo;
	public boolean isValidLogin(String userid, String password) {
		
		if(userid!=null && password!=null) {
			List<LoginPerson> persons = userRepo.findAll();
			if(persons!=null) {
				for(LoginPerson p:persons) {
					if(userid.equals(p.getName()) && password.equals(p.getPassword())) {
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	
	public LoginPerson getLoginPerson(String userid) {
		
		if(userid!=null) {
			List<LoginPerson> persons = userRepo.findAll();
			if(persons!=null) {
				for(LoginPerson p:persons) {
					if(userid.equals(p.getName())) {
						return p;
					}
				}
			}
			
		}
		return null;
	}
	
}

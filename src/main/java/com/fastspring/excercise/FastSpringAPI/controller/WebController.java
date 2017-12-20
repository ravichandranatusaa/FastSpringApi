package com.fastspring.excercise.FastSpringAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastspring.excercise.FastSpringAPI.domain.StoreSession;
import com.fastspring.excercise.FastSpringAPI.service.LoginService;
import com.fastspring.excercise.FastSpringAPI.service.StoreSessionService;

@Controller
public class WebController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	StoreSessionService storeSessionService;

	@RequestMapping(value="/")
	public String Default(){
		return "index";
	}

	@RequestMapping(value="/home")
	public String index(){
		return "home";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(@RequestParam("userid") String userid, @RequestParam("password") String password, @RequestParam("store") String storeid){
		if(loginService.isValidLogin(userid, password)) {
			int store = Integer.parseInt(storeid);
			StoreSession storeSession = storeSessionService.getStoreSession(userid, store);
			return "home";
		} else {
			
			return "index";
		}
	}

}

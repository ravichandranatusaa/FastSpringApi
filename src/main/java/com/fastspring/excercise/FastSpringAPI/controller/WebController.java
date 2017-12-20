package com.fastspring.excercise.FastSpringAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fastspring.excercise.FastSpringAPI.domain.Orders;
import com.fastspring.excercise.FastSpringAPI.domain.StoreSession;
import com.fastspring.excercise.FastSpringAPI.service.LoginService;
import com.fastspring.excercise.FastSpringAPI.service.OrdersService;
import com.fastspring.excercise.FastSpringAPI.service.StoreSessionService;

@Controller
public class WebController {

	@Autowired
	LoginService loginService;

	@Autowired
	StoreSessionService storeSessionService;
	
	@Autowired
	OrdersService ordersService;

	@RequestMapping(value="/")
	public String Default(){
		return "index";
	}

	@RequestMapping(value="/home")
	public String index(){
		return "home";
	}

	@RequestMapping(value="/login", method= RequestMethod.POST)
	public ModelAndView login(@RequestParam("userid") String userid, @RequestParam("password") String password, @RequestParam("store") String storeid){
		ModelAndView mav = new ModelAndView();
		if(loginService.isValidLogin(userid, password)) {
			Long store = Long.valueOf(storeid);
			StoreSession storeSession = storeSessionService.getStoreSession(userid, store);
			mav.addObject("storesession", storeSession);
			mav.setViewName("home");
			return mav;
		} else {
			mav.addObject("message", "Invalid credentials !!!");
			mav.setViewName("index");
			return mav;
		}
	}
	
	
	@RequestMapping(value="/order", method= RequestMethod.POST)
	public ModelAndView createOrder(@RequestParam("storesessionid") String storesessionid){
		ModelAndView mav = new ModelAndView();
		if(storesessionid!=null) {
			Orders order = ordersService.createOrder(Long.valueOf(storesessionid));
			mav.addObject("order", order);
		}
		mav.setViewName("order");
		return mav;
	}
	
	

}

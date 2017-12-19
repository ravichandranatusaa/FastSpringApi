package com.fastspring.excercise.FastSpringAPI.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {


	@Autowired
	ServletContext context;	

	@RequestMapping(value="/")
	public String Default(){
		return index();
	}

	@RequestMapping(value="/home")
	public String index(){
		return "index";
	}

}

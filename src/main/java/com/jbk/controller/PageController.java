package com.jbk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping(value = "/")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/addCustomerPage")
	public String addUserPage() {
		
			return "addCustomer";
		
		
	}
	
	
	
	
}

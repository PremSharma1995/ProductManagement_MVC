package com.jbk.controller;

import java.util.List;

import javax.persistence.PostLoad;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Customer;
import com.jbk.service.CustomerService;
import com.jbk.service.CustomerServiceImpl;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping(value = "/login")
	public String login(@ModelAttribute Customer customer, Model model, HttpSession session) {

		Customer customr = service.login(customer);

		if (customr != null) {
			String username = customr.getUsername();
			String role=customr.getRole();
			session.setAttribute("username", username);
			session.setAttribute("role", role);
			return "home";
		} else {
			model.addAttribute("msg", "Invalid Credientials !!");
			return "login";
		}

	}

	@PostMapping(value = "/addCustomer")
	public String addCustomer(@ModelAttribute Customer customer, Model model) {
		boolean isAdded = service.saveCustomer(customer);

		if (isAdded) {

			model.addAttribute("msg", "Customer Added !!");
			return "addCustomer";
		} else {
			model.addAttribute("msg", "Customer Not Added If Its Already Exists !!");
			return "addCustomer";
		}

	}

	@GetMapping(value = "/getAllCustomer")
	public String getAllCustomer(Model model) {

		List<Customer> list = service.getAllCustomer();
		model.addAttribute("customers", list);
		return "listOfCustomer";
	}

	@GetMapping(value = "/deleteCustomer")
	public String deleteCustomer(@RequestParam String username, Model model) {
		boolean isDeleted = service.deleteCustomer(username);
		if (isDeleted) {
			List<Customer> list = service.getAllCustomer();  // fetch updated list
			model.addAttribute("customers", list);
			return "listOfCustomer";
		} else {
			List<Customer> list = service.getAllCustomer();
			model.addAttribute("customers", list);

			return "listOfCustomer";
		}
	}

	@GetMapping(value = "/getProfile")
	public String getProfile(@RequestParam String username, Model model) {
		Customer customer = service.getProfile(username);
		model.addAttribute("customer", customer);
		return "profile";

	}

	@PostMapping(value = "/updateCustomer")
	public String updateCustomer(@ModelAttribute Customer customer, Model model) {

		boolean isUpdated = service.updateCustomer(customer);
		if (isUpdated) {
			model.addAttribute("msg", "Updated !!");
			return "home";
		} else {
			model.addAttribute("msg", " Not Updated !!");
			return "home";
		}

	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "login";

	}

}

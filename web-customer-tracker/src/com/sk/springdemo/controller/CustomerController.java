package com.sk.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.springdemo.entity.Customer;
import com.sk.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//NOTE: ADD CustomerServiceDeleted CustomerDAO injection because we added CustomerService as a middle layer to talk many databases. 
	
	// need to inject CustomerService
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		// get list of customer from ado 
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customer to model
		theModel.addAttribute("customers", theCustomers);
 		
		return "list-customers";
	}

	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// add customer 
		Customer theCustomer = new Customer();
		
		// add attribute
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
	
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") int theID, Model theModel){
		
		// get customer from database
		Customer theCustomer = customerService.getCustomer(theID);
		
		// add model attribute
		theModel.addAttribute(theCustomer);
		
		// send over the customer form 
		return "customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerID") int theID) {
		
		// delete customer from database
		customerService.deleteCustomer(theID);

		return "redirect:/customer/list";
	}
}

















package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
	// get customers from the dao
	List<Customer> theCustomers = customerService.getCustomers();

	// add customers to the model
	theModel.addAttribute("customers", theCustomers);

	return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

	// create model attribute to bind form data
	Customer theCustomer = new Customer();

	theModel.addAttribute("customer", theCustomer);

	return "customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
	Customer theCustomer = customerService.getCustomer(theId);
	
	theModel.addAttribute("customer", theCustomer);

	return "customer-form";
    }
    
    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("customerId") int theId, Model theModel) {
	//delete
	customerService.deleteCustomer(theId);
	
	return "redirect:/customer/list";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

	customerService.saveCustomer(theCustomer);

	return "redirect:/customer/list";
    }
}

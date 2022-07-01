package com.laptopshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshopping.model.Customer;
import com.laptopshopping.service.CustomerService;

@RestController
@RequestMapping("/customer") 
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	
	@PostMapping("/register")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.registerCustomer(customer), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.loginCustomer(customer), HttpStatus.OK);
	}

	@GetMapping
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@GetMapping("{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId,
			@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PutMapping("{customerId}")
	public ResponseEntity<Customer> updateAdmin(@PathVariable("customerId") int customerId,
			@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, customerId), HttpStatus.OK);
	}

	@DeleteMapping("{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>("admin deleted successfully ", HttpStatus.OK);
	}

}

package com.laptopshopping.service;

import java.util.List;

import com.laptopshopping.model.Customer;

public interface CustomerService {
	Customer registerCustomer(Customer customer);

	Customer loginCustomer(Customer customer);

	List<Customer> getAllCustomer();

	Customer updateCustomer(Customer customer, int customerId);

	Customer getCustomerById(int customerId);

	void deleteCustomer(int customerId);
}

package com.laptopshopping.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptopshopping.repository.CustomerRepository;
import com.laptopshopping.exception.ResourceNotFoundException;
import com.laptopshopping.model.Customer;
import com.laptopshopping.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer loginCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository
				.findByCustomerEmailIdAndCustomerPassword(customer.customerEmailId, customer.customerPassword)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "CustomerId",
						customer.customerEmailId + " and password" + customer.customerPassword));
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer, int customerId) {
		// TODO Auto-generated method stub
		Customer existingCustomer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "CustomerId",
						customer.customerEmailId + " and " + customer.customerPassword));
		existingCustomer.setCustomerEmailId(customer.getCustomerEmailId());
		existingCustomer.setCustomerFirstName(customer.getCustomerFirstName());
		existingCustomer.setCustomerLastName(customer.getCustomerLastName());
		existingCustomer.setCustomerPassword(customer.getCustomerPassword());
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer",
				"CustomerId", "customer is not found with this id" + customerId));
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","CustomerId",customerId));
		customerRepository.deleteById(customerId);
		
	}

}

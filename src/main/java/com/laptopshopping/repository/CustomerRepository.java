package com.laptopshopping.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshopping.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByCustomerEmailIdAndCustomerPassword(String emailId, String password);
}

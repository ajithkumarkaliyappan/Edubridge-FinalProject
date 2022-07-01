package com.laptopshopping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshopping.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Optional<Payment> findByOrderId(int orderId);
}

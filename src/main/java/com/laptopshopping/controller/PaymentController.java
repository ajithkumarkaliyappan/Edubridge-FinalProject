package com.laptopshopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshopping.model.Payment;
import com.laptopshopping.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/makePayment/{orderId}")
	public ResponseEntity<Payment> makePayment(@PathVariable("orderId") int orderId,@Valid @RequestBody Payment payment) {
		return new ResponseEntity<Payment>(paymentService.makePayment(orderId, payment),HttpStatus.OK);
	}
}

package com.laptopshopping;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.laptopshopping.model.Order;
import com.laptopshopping.model.Payment;
import com.laptopshopping.repository.OrderRepository;
import com.laptopshopping.repository.PaymentRepository;
import com.laptopshopping.service.OrderService;

@SpringBootTest
class PaymentTestCase {
	
	@Autowired
	private PaymentRepository paymentRepository;
	private OrderService orderService;
	private OrderRepository orderRepository;
	
	@Test
	//@Disabled
	//@Order(1)
	public void makePayment() {
		Payment payment = new Payment();
		Order order = orderRepository.getOne(10051);
		payment.setOrderId(10051);
		payment.setCardNumber(1234567899);
		payment.setCvv(123);
		payment.setTotalPrice(order.getTotalPrice());
		payment.setPaymentPaidDate(LocalDate.now());
		payment.setPaidAmount(order.getTotalPrice());
		if (payment.getTotalPrice() == payment.getPaidAmount()) {
			payment.setPaymentStatus("PAID");
			order.setDeliveryStatus("Delivered");
		} else {

			payment.setPaymentStatus("NOT-PAID");
			order.setDeliveryStatus("payment pending");
		}
		assertNotNull(paymentRepository.save(payment));
	}
}

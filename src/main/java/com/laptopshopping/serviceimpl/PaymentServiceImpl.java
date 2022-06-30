package com.laptopshopping.serviceimpl;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptopshopping.exception.ResourceNotFoundException;
import com.laptopshopping.model.Order;
import com.laptopshopping.model.Payment;
import com.laptopshopping.repository.OrderRepository;
import com.laptopshopping.repository.PaymentRepository;
import com.laptopshopping.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Payment makePayment(int orderId, Payment payment) {
		// TODO Auto-generated method stub
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));
		payment.setOrderId(orderId);
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
		return paymentRepository.save(payment);
	}

}

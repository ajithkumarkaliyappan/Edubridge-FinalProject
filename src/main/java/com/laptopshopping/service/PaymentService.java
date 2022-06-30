package com.laptopshopping.service;

import com.laptopshopping.model.Payment;

public interface PaymentService {

	Payment makePayment(int orderId,Payment payment);
}

package com.laptopshopping;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.laptopshopping.model.Feedback;
import com.laptopshopping.model.Order;
import com.laptopshopping.repository.FeedbackRepository;
import com.laptopshopping.service.OrderService;

class FeedbackTestCase {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private OrderService orderService;

	@Test
	public void testAddFeedback() {
		Feedback feedback = new Feedback();
		Order order = orderService.getOrderById(10051);
		feedback.setOrderId(order.getOrderId());
		feedback.setProductId(order.getProductId());
		feedback.setComment("good product good for basic uses");
		assertNotNull(feedbackRepository.save(feedback));
	}

}

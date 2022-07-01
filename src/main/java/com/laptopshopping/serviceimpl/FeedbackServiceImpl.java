package com.laptopshopping.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptopshopping.exception.ResourceNotFoundException;
import com.laptopshopping.model.Feedback;
import com.laptopshopping.model.Order;
import com.laptopshopping.repository.FeedbackRepository;
import com.laptopshopping.service.FeedbackService;
import com.laptopshopping.service.OrderService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private OrderService orderService;
	
	@Override
	public Feedback addFeedback(Feedback feedback,int orderId) {
		// TODO Auto-generated method stub
		Order order = orderService.getOrderById(orderId);
		feedback.setOrderId(orderId);
		feedback.setProductId(order.getProductId());
		return feedbackRepository.save(feedback);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback, int feedbackId) {
		// TODO Auto-generated method stub
		Feedback existingFeedback = feedbackRepository.findById(feedbackId).orElseThrow(
				() -> new ResourceNotFoundException("Feedback", "feedbackId", "feedback with this id is not found"));
		existingFeedback.setComment(feedback.getComment());
		feedbackRepository.save(existingFeedback);
		return existingFeedback;
	}

	@Override
	public void removeFeedback(int feedbackId) {
		// TODO Auto-generated method stub
		feedbackRepository.findById(feedbackId).orElseThrow(() -> new ResourceNotFoundException("Feedback", "feedbackId", "feedback with this id is not found"));
	    feedbackRepository.deleteById(feedbackId);
	}

	@Override
	public List<Feedback> getAllFeedbackOfProduct(int productId) {
		// TODO Auto-generated method stub
		return feedbackRepository.findByProductId(productId);
	}
	
	
}

package com.laptopshopping.service;

import java.util.List;

import com.laptopshopping.model.Feedback;

public interface FeedbackService {

	Feedback addFeedback(Feedback feedback, int orderId);

	Feedback updateFeedback(Feedback feedback, int feedbackId);

	void removeFeedback(int feedbackId);
	
	List<Feedback> getAllFeedbackOfProduct(int productId);
}

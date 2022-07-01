package com.laptopshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshopping.model.Feedback;
import com.laptopshopping.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/addFeedback/{orderId}")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback,@PathVariable("orderId") int orderId) {
		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback,orderId), HttpStatus.CREATED);
	}

	@PutMapping("/updateFeedback/{feedbackId}")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback, @Valid @PathVariable("feedbackId")int feedbackId){
		return new ResponseEntity<Feedback>(feedbackService.updateFeedback(feedback, feedbackId),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFeedback/{feedbackId}")
	public ResponseEntity<String> deleteFeedback( @PathVariable("feedbackId")int feedbackId){
		feedbackService.removeFeedback(feedbackId);
		return new ResponseEntity<String>("feedback deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getAllFeedbackOfProduct/{productId}")
	public List<Feedback> getAllFeedbackOfProduct(@PathVariable("productId") int productId){
		/*
		 * List<Feedback> feedback = feedbackService.getAllFeedbackOfProduct(productId);
		 * return feedback.toString();
		 */
		return feedbackService.getAllFeedbackOfProduct(productId);
	}
}

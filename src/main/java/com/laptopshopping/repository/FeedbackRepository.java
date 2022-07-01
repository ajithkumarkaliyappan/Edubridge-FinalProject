package com.laptopshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshopping.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	List<Feedback> findByProductId(int productId);

}

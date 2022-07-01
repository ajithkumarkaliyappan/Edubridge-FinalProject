package com.laptopshopping.model;

import javax.persistence.*;

@Entity
@Table(name="feedback_table")
@SequenceGenerator(name="feedbackGene",sequenceName="feedbackGeneration", initialValue=500000)
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="feedbackGene")
	@Column(name="feedback_id")
	private int feedbackId;
	
	@Column(name="order_Id")
	private int orderId;
	
	@Column(name="product_Id")
	private int productId;
	
	@Column(name="comment")
	private String comment;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}

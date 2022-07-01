package com.laptopshopping.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="order_table")
@SequenceGenerator(name="orderGene",sequenceName="orderGeneration", initialValue=10000)
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="orderGene")
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="product_id",nullable=false)
	private int ProductId;
	
	@Column(name="customer_id",nullable=false)
	private int customerId;
	
	@Column(name="product_price",nullable=false)
	private int productPrice;
	
	@Column(name="quantity",nullable=false)
	private int quantity;
	
	@Column(name="total_price",nullable=false)
	private int totalPrice;
	
	@Column(name="delivery_status")
	@Value(value = "payment pending")
	private String deliveryStatus;

	@Column(name="ordered_date")
	private LocalDate orderedDate;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customer) {
		this.customerId = customer;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDate localDate) {
		this.orderedDate = localDate;
	}
	
	
	
}

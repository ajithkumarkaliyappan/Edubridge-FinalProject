package com.laptopshopping.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "payment_table")
@SequenceGenerator(name="paymentGene",sequenceName="paymentGeneration", initialValue=100000)
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paymentGene")
	@Column(name = "paymentId")
	private int paymentId;

	@Column(name = "order_id",unique=true)
	private int orderId;

	@Column(name = "total_price")
	private int totalPrice;

	@Column(name = "card_number")
	private long cardNumber;

	private int cvv;

	@Column(name = "paid_amount", nullable = false)
	private int paidAmount;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "paid_date")
	private LocalDate paymentPaidDate;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDate getPaymentPaidDate() {
		return paymentPaidDate;
	}

	public void setPaymentPaidDate(LocalDate localDate) {
		this.paymentPaidDate = localDate;
	}

}

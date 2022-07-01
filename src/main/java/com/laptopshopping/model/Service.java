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
@Table(name = "service_table")
@SequenceGenerator(name="serviceGene",sequenceName="serviceGeneration", initialValue=5000000)
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="serviceGene")
	@Column(name = "service_id")
	private int serviceId;

	@Column(name = "service_detail", nullable = false)
	private String serviceDetail;

	@Column(name = "order_id", unique=true,nullable = false)
	private int orderId;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "customer_id", nullable = false)
	private int customerId;

	@Column(name = "service_status")
	@Value(value = "service pending")
	private String serviceStatus;
	
	@Column(name="service_date")
	private LocalDate serviceDate;

	public LocalDate getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(LocalDate serviceDate) {
		this.serviceDate = serviceDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDetail() {
		return serviceDetail;
	}

	public void setServiceDetail(String serviceDetail) {
		this.serviceDetail = serviceDetail;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}

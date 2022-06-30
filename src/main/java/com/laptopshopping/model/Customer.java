package com.laptopshopping.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
@Table(name="customer_table")
@SequenceGenerator(name="customerGene",sequenceName="customerGeneration", initialValue=1000)
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customerGene")
	@Column(name="customerId")
	private int customerId;

	@Column(name="first_name",unique=true,nullable=false)
	@NotEmpty
	@Size(min=3, message="firstName must contain atleast 3 characters")
	public String customerFirstName;
	
	@Column(name="last_name")
	@NotEmpty
	@Size(min=3, message="lastName must contain atleast 3 characters")
	public String customerLastName;
	
	@Column(name="password",unique=true,nullable=false)
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String customerPassword;
	
	@Column(name="emailId",unique=true,nullable=false)
	@NotEmpty
	@Email(message="email is not valid")
	@Pattern(regexp=".+@.+\\..+",message="please provide a valid email addresss")
	public String customerEmailId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	
	
}

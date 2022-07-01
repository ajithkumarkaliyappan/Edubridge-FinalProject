package com.laptopshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin_table")
@SequenceGenerator(name="adminGene",sequenceName="adminGeneration", initialValue=1)
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="adminGene")
	@Column(name="admin_id")
	private int adminId;
	
	@Column(name="first_name" ,unique=true,nullable = false)
	@NotEmpty
	@Size(min=3, message="firstName must contain atleast 3 characters")
	public String adminFirstName;
	
	@Column(name="last_name")
	@NotEmpty
	@Size(min=3, message="lastName must contain atleast 3 characters")
	public String adminLastName;
	
	@Column(name="password",unique=true,nullable=false)
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String adminPassword;
	
	@Column(name="emailId",unique=true, nullable = false)
	@NotEmpty
	@Email(message="email is not valid")
	@Pattern(regexp=".+@.+\\..+",message="please provide a valid email addresss")
	public String adminEmailId;
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
}

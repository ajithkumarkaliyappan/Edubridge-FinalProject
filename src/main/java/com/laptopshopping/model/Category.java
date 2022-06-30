package com.laptopshopping.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="category_table")
@SequenceGenerator(name="categoryGene",sequenceName="categoryGeneration", initialValue=100)
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categoryGene")
	@Column(name = "categoryId")
	private int categoryId;

	@Column(name="categoryName",unique=true)
	@NotNull
	@Size(min=4,message="category name atleast contains 4 characters")
	public String categoryName;
	
	@Column(name="category_discription")
	@NotNull
	private String categoryDiscription;
	
	@Column(name="admin_id")
	@NotNull
	private int adminId;
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDiscription() {
		return categoryDiscription;
	}

	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}	
	
}

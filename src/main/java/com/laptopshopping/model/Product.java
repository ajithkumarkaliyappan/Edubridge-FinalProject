package com.laptopshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "product_table")
@SequenceGenerator(name = "productGene", sequenceName = "productGeneration", initialValue = 55555)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGene")
	@Column(name = "productId")
	private int productId;

	@Column(name = "product_company", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "product name must contain atleat 3 words")
	public String productCompany;

	@Column(name = "product_model", unique = true)
	@NotEmpty
	@Size(min = 3, message = "product model must contain atleat 3 words")
	public String productModel;

	@Column(name = "product_price", nullable = false)
	@NotNull
	public int productPrice;

	@Column(name = "product_features", nullable = false)
	@NotEmpty
	public String productFeatures;

	@Column(name = "category_id")
	private int categoryId;

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductFeatures() {
		return productFeatures;
	}

	public void setProductFeatures(String productFeatures) {
		this.productFeatures = productFeatures;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}

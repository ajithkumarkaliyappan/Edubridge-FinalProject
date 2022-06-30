package com.laptopshopping.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="wishlist")
@SequenceGenerator(name="wishlistGene",sequenceName="wishlistGeneration", initialValue=100)
public class Wishlist {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="wishlistGene")
	@Column(name="wishlist_id")
	private int wishlistId;
	
	@Column(name="wishlist_Name")
	@Size(min=3, message="wishlist name should be atleast 3 characters fro eg:company name or product type")
	public String wishlistName;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRODUCT_ID", unique=true)
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

	public Wishlist() {
	}

	public String getWishlistName() {
		return wishlistName;
	}

	public void setWishlistName(String wishlistName) {
		this.wishlistName = wishlistName;
	}

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlist_no) {
		this.wishlistId = wishlist_no;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}

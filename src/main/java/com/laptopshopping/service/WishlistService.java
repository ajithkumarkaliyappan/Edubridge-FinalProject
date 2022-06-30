package com.laptopshopping.service;

import java.util.List;

import com.laptopshopping.model.Product;
import com.laptopshopping.model.Wishlist;

public interface WishlistService {

	Wishlist addProductToWishlist(int productId,Wishlist wishlist);

	void deleteProductById(int wishlistId);
	
	List<Wishlist> viewWishlistProducts();
	
	Product viewProduct(int wishlistId);

	Wishlist getByWishlistId(int wishlistId);
}

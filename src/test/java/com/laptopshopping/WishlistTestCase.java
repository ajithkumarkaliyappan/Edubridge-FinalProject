package com.laptopshopping;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.laptopshopping.model.Product;
import com.laptopshopping.model.Wishlist;
import com.laptopshopping.repository.WishlistRepository;
import com.laptopshopping.service.ProductService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WishlistTestCase {

	@Autowired
	private WishlistRepository wishlistRepository;
	@Autowired
	private ProductService productService;

	@Test
	@Order(1)
	@Disabled
	public void addProductToWishlist() {
		Wishlist wishlist = new Wishlist();
		wishlist.setWishlistName("hp laptop");
		Product product = productService.getByProductId(201);
		wishlist.setProduct(product);
		assertNotNull(wishlistRepository.save(wishlist));
	}

	@Test

	@Order(2)

	//@Disabled
	public void viewProductFromWishlist() {
		List<Wishlist> wishlistProduct = wishlistRepository.findAll();
		assertThat(wishlistProduct).size().isGreaterThan(0);
	}

	@Test

	@Order(3)
	public void getByWishlistId() {
		Wishlist wishlist = wishlistRepository.findById(251).get();
		assertThat(wishlist.getWishlistId()).isEqualTo(251);
	}

	@Test

	@Order(4)
	public void viewWishlistProduct() {
		Product product = wishlistRepository.findById(251).get().getProduct();
		System.out.println(product.getProductCompany() + " " + product.getProductModel() + " "
				+ product.getProductFeatures() + " " + product.getProductPrice());

	}

}

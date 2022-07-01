package com.laptopshopping.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshopping.model.Wishlist;
import com.laptopshopping.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
	@Autowired
	private WishlistService wishlistService;

	@PostMapping("/addProduct/{productId}")
	public ResponseEntity<Wishlist> addProductToWishlist(@PathVariable("productId") int productId,
			@Valid @RequestBody Wishlist wishlist) {
		return new ResponseEntity<Wishlist>(wishlistService.addProductToWishlist(productId, wishlist),HttpStatus.CREATED);

	}

	@DeleteMapping("/deleteProduct/{wishlistId}")
	public ResponseEntity<String> deleteProductFromWishlist(@RequestBody Wishlist wishlist,
			@PathVariable("wishlistId") int wishlistId) {
		wishlistService.deleteProductById(wishlistId);
		return new ResponseEntity<String>("product from wishlist with id " + wishlistId + " deleted successfully ",HttpStatus.GONE);
	}
	
	@GetMapping
	public List<Wishlist> getAllWishlistProducts(){
		return wishlistService.viewWishlistProducts();
	}

	@GetMapping("{wishlistId}")
	public ResponseEntity<Wishlist> getByWishlistId(@PathVariable("wishlistId") int wishlistId,@RequestBody Wishlist wishlist){
		return new ResponseEntity<Wishlist>(wishlistService.getByWishlistId(wishlistId),HttpStatus.FOUND);
	}

}

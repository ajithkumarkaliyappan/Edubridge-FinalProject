package com.laptopshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshopping.model.Product;
import com.laptopshopping.service.ProductService;

@RestController
@RequestMapping("/product")
//http://localhost:8089/product
public class ProductController {
	@Autowired
	private ProductService productService;


	@PostMapping("/addProduct/{adminId}/{categoryId}")
	public ResponseEntity<Product> addProduct(@RequestBody Product product,@PathVariable("categoryId")int categoryId,@PathVariable("adminId")int adminId) {
		return new ResponseEntity<Product>(productService.addProduct( product,adminId,categoryId), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	@GetMapping("{productId}")
	public ResponseEntity<Product> getByProductId(@RequestBody Product product,
			@PathVariable("productId") int productId) {
		return new ResponseEntity<Product>(productService.getByProductId(productId), HttpStatus.OK);
	}

	@PutMapping("{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId,
			@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product, productId), HttpStatus.OK);
	}

	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable("productId") int productId) {
		productService.deleteProductById(productId);
		return new ResponseEntity<String>("product deleted successfully ", HttpStatus.OK);
	}


}

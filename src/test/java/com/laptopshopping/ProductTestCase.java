package com.laptopshopping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.laptopshopping.model.Product;
import com.laptopshopping.repository.ProductRepository;

@SpringBootTest
class ProductTestCase {
	@Autowired
	private ProductRepository productRepository;

	@Test
	@Order(1)
	@Disabled
	public void addProduct() {
		Product product = new Product();
		product.setCategoryId(151);
		product.setProductModel("HP 15q");
		product.setProductCompany("HP");
		product.setProductFeatures("4gb ram , 1tb internal storage");
		product.setProductPrice(27000);
		assertNotNull(productRepository.save(product));
	}

	@Test
	//@Disabled
	@Order(2)
	public void getAllProduct() {
		List<Product> product = productRepository.findAll();
		assertThat(product).size().isGreaterThan(0);
	}

	@Test
	//@Disabled
	@Order(3)
	public void getProductById() {
		Product product = productRepository.findById(201).get();
		assertThat(product.getProductId()).isEqualTo(201);
	}

	@Test
	//@Disabled
	@Order(4)
	public void updateProduct() {
		Product product = productRepository.findById(201).get();
		product.setProductPrice(30000);
		product.setCategoryId(151);
		Product updatedProduct = productRepository.save(product);
		assertThat(updatedProduct.productPrice);
	}

	@Test
	@Disabled
	@Order(5)
	public void deleteProduct() {
		Product product = productRepository.findById(2).get();
		productRepository.delete(product);
	}

}

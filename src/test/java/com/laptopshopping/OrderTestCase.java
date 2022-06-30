package com.laptopshopping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.laptopshopping.model.Order;
import com.laptopshopping.model.Product;
import com.laptopshopping.repository.OrderRepository;
import com.laptopshopping.repository.ProductRepository;
import com.laptopshopping.service.ProductService;


@SpringBootTest
class OrderTestCase {

	@Autowired
	private OrderRepository orderRepository;
	private ProductService productService;
	
	@Test
	//@Disabled
	public void addProduct(){
		Order order = new Order();
		order.setCustomerId(1000);
		order.setProductId(55555);
		//Product product = productService.getByProductId(55555);
		order.setProductPrice(36370);
		order.setQuantity(1);
		order.setTotalPrice(order.getQuantity() * order.getProductPrice());
		order.setOrderedDate(java.time.LocalDate.now());
		order.setDeliveryStatus("payment pending");
		assertNotNull(orderRepository.save(order));
	}
	
}

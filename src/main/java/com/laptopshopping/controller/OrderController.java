package com.laptopshopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshopping.model.Order;
import com.laptopshopping.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/addProduct/{productId}/{customerId}")
	public ResponseEntity<Order> addProductToCart(@Valid @RequestBody Order order,@PathVariable("productId") int productId,@PathVariable("customerId")int customerId) {
		return new ResponseEntity<Order>(orderService.addProductToOrder(order,productId,customerId), HttpStatus.CREATED);
	}

	@PutMapping("{orderId}")
	public ResponseEntity<Order> updateProductInOrders(@PathVariable("orderId") int orderId, @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.updateProductFromOrder(order, orderId), HttpStatus.OK);
	}

	@DeleteMapping("{orderId}")
	public ResponseEntity<String> deletePoductFromOrder(@PathVariable("orderId") int orderId) {
		orderService.deleteProductFromOrder(orderId);
		return new ResponseEntity<String>("products from the order Id " + orderId + " is deleted successfully",
				HttpStatus.OK);
	}
}

package com.laptopshopping.service;

import com.laptopshopping.model.Order;

public interface OrderService {

	Order addProductToOrder(Order order,int productId,int customerId);

	Order updateProductFromOrder(Order order, int orderId);

	void deleteProductFromOrder(int orderId);
	
	Order getOrderById(int orderId);
}

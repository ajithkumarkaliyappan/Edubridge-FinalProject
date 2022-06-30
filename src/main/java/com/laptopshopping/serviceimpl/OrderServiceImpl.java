package com.laptopshopping.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptopshopping.exception.ResourceNotFoundException;
import com.laptopshopping.model.Order;
import com.laptopshopping.model.Product;
import com.laptopshopping.repository.OrderRepository;
import com.laptopshopping.service.OrderService;
import com.laptopshopping.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired 
	private ProductService productService;
	
	@Override
	public Order addProductToOrder(Order order,int productId,int customerId) {
		// TODO Auto-generated method stub
		Product product = productService.getByProductId(productId);
		order.setCustomerId(customerId);
		order.setProductId(productId);
		order.setProductPrice(product.getProductPrice());
		order.setOrderedDate(java.time.LocalDate.now());
		order.setDeliveryStatus("payment pending");
		order.setTotalPrice(order.getProductPrice() * order.getQuantity());
		return orderRepository.save(order);
	}

	@Override
	public Order updateProductFromOrder(Order order, int orderId) {
		// TODO Auto-generated method stub
		Order existingOrder = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));
		existingOrder.setCustomerId(order.getCustomerId());
		existingOrder.setProductId(order.getProductId());
		existingOrder.setProductPrice(order.getProductPrice());
		existingOrder.setQuantity(order.getQuantity());
		existingOrder.setTotalPrice(order.getTotalPrice());
		//existingOrder.setDeliveryStatus("payment pending");
		orderRepository.save(existingOrder);
		return existingOrder;
	}

	@Override
	public void deleteProductFromOrder(int orderId) {
		// TODO Auto-generated method stub
		orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));
		orderRepository.deleteById(orderId);

	}

	@Override
	public Order getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));
		
	}

}

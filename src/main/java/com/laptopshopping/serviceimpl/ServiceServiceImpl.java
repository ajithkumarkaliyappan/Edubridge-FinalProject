package com.laptopshopping.serviceimpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptopshopping.model.Order;
import com.laptopshopping.repository.ServiceRepository;
import com.laptopshopping.service.OrderService;
import com.laptopshopping.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private OrderService orderService;
	
	int count = 1;

	@Override
	public com.laptopshopping.model.Service addService(com.laptopshopping.model.Service service, int orderId) {
		// TODO Auto-generated method stub
			Order order = orderService.getOrderById(orderId);
		service.setProductId(order.getProductId());
		service.setOrderId(orderId);
		service.setCustomerId(order.getCustomerId());
		service.setServiceDate(java.time.LocalDate.now());
		LocalDate orderedDate = order.getOrderedDate();
		LocalDate serviceDate = service.getServiceDate();
		int differenceDays = orderedDate.getDayOfYear() - serviceDate.getDayOfYear();
		if (differenceDays < 366 && count == 1) {
			count = count + 1;
			service.setServiceStatus("your service accepted. Service process completed within 7 days");
		} else {
			service.setServiceStatus("Sorry!! your product free Service period limit exceeds");
		}	
		return serviceRepository.save(service);
	}

}

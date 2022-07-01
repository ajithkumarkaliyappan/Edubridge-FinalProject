package com.laptopshopping;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.laptopshopping.model.Order;
import com.laptopshopping.model.Service;
import com.laptopshopping.repository.ServiceRepository;
import com.laptopshopping.service.OrderService;

@SpringBootTest
class ServiceTestCase {

	@Autowired 
	private ServiceRepository serviceRepository;
	@Autowired
	private OrderService orderService;
	int count=1;
	@Test
	public void addService() {
		
		Service service = new Service();
		Order order = orderService.getOrderById(10051);
		service.setProductId(order.getProductId());
		service.setOrderId(10051);
		service.setCustomerId(order.getCustomerId());
		service.setServiceDate(java.time.LocalDate.now());
		service.setServiceDetail("Hardware probem");
		LocalDate orderedDate = order.getOrderedDate();
		LocalDate serviceDate = service.getServiceDate();
		int differenceDays = orderedDate.getDayOfYear() - serviceDate.getDayOfYear();
		if (differenceDays < 366 && count == 1) {
			count = count + 1;
			service.setServiceStatus("your service accepted. Service process completed within 7 days");
		} else {
			service.setServiceStatus("Sorry!! your product free Service period limit exceeds");
		}	
		assertNotNull( serviceRepository.save(service));
	}

}

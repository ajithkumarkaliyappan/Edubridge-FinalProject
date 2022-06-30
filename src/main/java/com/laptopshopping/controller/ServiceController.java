package com.laptopshopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshopping.model.Service;
import com.laptopshopping.service.ServiceService;


@RestController
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private ServiceService serviceService;

	@PostMapping("addService/{orderId}")
	public ResponseEntity<Service> addServices(@Valid @RequestBody Service service,
			@PathVariable("orderId") int orderId) {
		return new ResponseEntity<Service>(serviceService.addService(service, orderId), HttpStatus.CREATED);
	}

}

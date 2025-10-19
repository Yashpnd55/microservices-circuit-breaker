package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceRestConsumer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	
	@Autowired
	private IBillingServiceRestConsumer client;
	
	@GetMapping("/details")
	@CircuitBreaker(name="Shopping-Service", fallbackMethod="displayShoppingDetails")
	public ResponseEntity<String> displayShoppingDetails() {
		System.out.println("ShoppingController:: client comp class name:: " + client.getClass());
		return new ResponseEntity<String>("Diwali Shopping for Family...."+client.fetchBillDetails(), HttpStatus.OK);
	}
	
	public ResponseEntity<String> displayShoppingDetails(Exception ex) {
		return new ResponseEntity<String>("Billing service is not available at this time!!"+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

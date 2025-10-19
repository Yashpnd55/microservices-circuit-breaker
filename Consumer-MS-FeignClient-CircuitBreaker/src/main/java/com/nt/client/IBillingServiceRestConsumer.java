package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Billing-Service")
public interface IBillingServiceRestConsumer {
	
	@GetMapping("/billing/api/info")
	public String fetchBillDetails();

}

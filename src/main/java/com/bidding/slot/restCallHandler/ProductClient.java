package com.bidding.slot.restCallHandler;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="PRODUCT")
public interface ProductClient {
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable Long productId);
}

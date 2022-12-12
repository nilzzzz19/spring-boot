package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

	ProductCustomerData data = new ProductCustomerData();
	
	@GetMapping("/get-products")
	public Product getProduct() {
		return data.getProductCustData();
	}
}

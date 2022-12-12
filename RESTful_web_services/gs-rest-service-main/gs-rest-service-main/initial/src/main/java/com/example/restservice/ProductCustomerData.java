package com.example.restservice;



import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class ProductCustomerData {

	private final AtomicLong counter = new AtomicLong();
	Customer c1 = new Customer("VEER");			
	Product p1 = new Product(counter.getAndIncrement(), "EDIBLES");
	
	Customer c2 = new Customer("SAI");			
	Product p2 = new Product(counter.getAndIncrement(), "INDICA");
	
	Customer c3 = new Customer("NILAY");			
	Product p3 = new Product(counter.getAndIncrement(), "SATIVA");
	
	
	public Product getProductCustData() {
		Random r = new Random();
		List<Product> plist = Arrays.asList(p1,p2,p3);
		int randomIndex = r.nextInt(plist.size());
		return plist.get(randomIndex);
	}
	
}

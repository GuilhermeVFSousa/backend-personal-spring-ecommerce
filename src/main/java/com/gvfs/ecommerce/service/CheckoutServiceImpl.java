package com.gvfs.ecommerce.service;

import org.springframework.stereotype.Service;

import com.gvfs.ecommerce.dto.Purchase;
import com.gvfs.ecommerce.dto.PurchaseResponse;
import com.gvfs.ecommerce.repositories.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public PurchaseResponse placeOrder(Purchase purchase) {
		// TODO Auto-generated method stub
		return null;
	}

}

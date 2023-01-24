package com.gvfs.ecommerce.service;

import com.gvfs.ecommerce.dto.Purchase;
import com.gvfs.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}

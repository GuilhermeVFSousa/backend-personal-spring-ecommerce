package com.gvfs.ecommerce.service;

import com.gvfs.ecommerce.dto.PaymentInfo;
import com.gvfs.ecommerce.dto.Purchase;
import com.gvfs.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);
	
	PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

}

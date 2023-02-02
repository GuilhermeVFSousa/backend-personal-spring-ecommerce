package com.gvfs.ecommerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gvfs.ecommerce.dto.PaymentInfo;
import com.gvfs.ecommerce.dto.Purchase;
import com.gvfs.ecommerce.dto.PurchaseResponse;
import com.gvfs.ecommerce.entity.Customer;
import com.gvfs.ecommerce.entity.Order;
import com.gvfs.ecommerce.entity.OrderItem;
import com.gvfs.ecommerce.repositories.CustomerRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository, @Value("${stripe.key.secret}") String secretKey) {
		this.customerRepository = customerRepository;
		
		// inicializando Stripe API com secret Key
		Stripe.apiKey = secretKey;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		// recebendo o order do DTO
		Order order = purchase.getOrder();
		
		// gerando o tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		// populando o order com os orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item)); // percorrer todos os itens do collection e add
		
		// populando o order com billingAddress e shippingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		// populando o customer com o order
		Customer customer = purchase.getCustomer();
		
		// verificar se o cliente já existe (byEmail)
		String theEmail = customer.getEmail();
		
		Customer customerFromDB = customerRepository.findByEmail(theEmail);
		
		if (customerFromDB != null) {
			// atribuir os dados ao customer existente
			customer = customerFromDB;
		}
		
		customer.add(order);
		
		// salvando no banco de dados
		customerRepository.save(customer);
		
		// retorna o response
		return new PurchaseResponse(orderTrackingNumber);
		
	}

	private String generateOrderTrackingNumber() {
		
		// gerar um UUID aleatório (UUID version-4)
		return UUID.randomUUID().toString();
	}

	@Override
	public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {
		
		List<String> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");
		
		Map<String, Object> params = new HashMap<>();
		params.put("amount", paymentInfo.getAmount());
		params.put("currency", paymentInfo.getCurrency());
		params.put("payment_method_types", paymentMethodTypes);
		params.put("description", "PersonalShop compra");
		
		return PaymentIntent.create(params);
	}
	

}

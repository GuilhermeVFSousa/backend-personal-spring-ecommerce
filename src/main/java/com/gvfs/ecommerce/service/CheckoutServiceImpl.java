package com.gvfs.ecommerce.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gvfs.ecommerce.dto.Purchase;
import com.gvfs.ecommerce.dto.PurchaseResponse;
import com.gvfs.ecommerce.entity.Customer;
import com.gvfs.ecommerce.entity.Order;
import com.gvfs.ecommerce.entity.OrderItem;
import com.gvfs.ecommerce.repositories.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
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
	

}

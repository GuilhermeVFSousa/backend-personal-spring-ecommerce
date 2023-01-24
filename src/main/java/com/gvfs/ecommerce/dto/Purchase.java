package com.gvfs.ecommerce.dto;

import java.util.Set;

import com.gvfs.ecommerce.entity.Address;
import com.gvfs.ecommerce.entity.Customer;
import com.gvfs.ecommerce.entity.Order;
import com.gvfs.ecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {
	
	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;

}

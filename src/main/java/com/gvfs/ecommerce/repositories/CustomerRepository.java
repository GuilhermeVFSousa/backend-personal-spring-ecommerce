package com.gvfs.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvfs.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

package com.pahanaedu.billingsystem.repository;

import com.pahanaedu.billingsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom query methods if needed
}

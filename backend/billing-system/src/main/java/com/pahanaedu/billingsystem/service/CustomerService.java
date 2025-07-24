package com.pahanaedu.billingsystem.service;

import com.pahanaedu.billingsystem.model.Customer;
import com.pahanaedu.billingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long accountNo) {
        return customerRepository.findById(accountNo);
    }

    public Customer createCustomer(Customer customer) {
        customer.setCreatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long accountNo, Customer customerDetails) {
        return customerRepository.findById(accountNo).map(customer -> {
            customer.setName(customerDetails.getName());
            customer.setAddress(customerDetails.getAddress());
            customer.setPhoneNo(customerDetails.getPhoneNo());
            return customerRepository.save(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void deleteCustomer(Long accountNo) {
        customerRepository.deleteById(accountNo);
    }
}

package com.pahanaedu.billingsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNo;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false, length = 15)
    private String phoneNo;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Customer() {}

    public Customer(String name, String address, String phoneNo, LocalDateTime createdAt) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    // ...
}

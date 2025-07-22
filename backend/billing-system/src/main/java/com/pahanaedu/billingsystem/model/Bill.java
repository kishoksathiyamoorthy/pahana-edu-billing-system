package com.pahanaedu.billingsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private LocalDateTime billDate;

    public Bill() {}

    public Bill(Customer customer, User user, Double totalAmount, LocalDateTime billDate) {
        this.customer = customer;
        this.user = user;
        this.totalAmount = totalAmount;
        this.billDate = billDate;
    }

    // Getters and Setters
    // ...
}

package com.pahanaedu.billingsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    public Item() {}

    public Item(String author, String title, Double price, Integer stock) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    // ...
}

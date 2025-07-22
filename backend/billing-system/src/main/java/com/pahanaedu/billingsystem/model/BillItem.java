package com.pahanaedu.billingsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bill_items")
public class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double subtotal;

    public BillItem() {}

    public BillItem(Bill bill, Item item, Integer quantity, Double subtotal) {
        this.bill = bill;
        this.item = item;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    // Getters and Setters
    // ...
}

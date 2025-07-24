package com.pahanaedu.billingsystem.controller;

import com.pahanaedu.billingsystem.model.BillItem;
import com.pahanaedu.billingsystem.service.BillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-items")
public class BillItemController {

    @Autowired
    private BillItemService billItemService;

    @GetMapping
    public List<BillItem> getAllBillItems() {
        return billItemService.getAllBillItems();
    }

    @PostMapping
    public BillItem createBillItem(@RequestBody BillItem billItem) {
        return billItemService.createBillItem(billItem);
    }
}

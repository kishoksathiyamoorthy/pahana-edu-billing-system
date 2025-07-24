package com.pahanaedu.billingsystem.service;

import com.pahanaedu.billingsystem.model.BillItem;
import com.pahanaedu.billingsystem.repository.BillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillItemService {

    @Autowired
    private BillItemRepository billItemRepository;

    public List<BillItem> getAllBillItems() {
        return billItemRepository.findAll();
    }

    public BillItem createBillItem(BillItem billItem) {
        return billItemRepository.save(billItem);
    }
}

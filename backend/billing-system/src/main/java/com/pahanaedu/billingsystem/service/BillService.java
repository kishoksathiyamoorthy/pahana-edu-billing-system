package com.pahanaedu.billingsystem.service;

import com.pahanaedu.billingsystem.model.Bill;
import com.pahanaedu.billingsystem.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill createBill(Bill bill) {
        bill.setBillDate(LocalDateTime.now());
        return billRepository.save(bill);
    }
}

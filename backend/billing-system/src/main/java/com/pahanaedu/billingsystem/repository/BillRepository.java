package com.pahanaedu.billingsystem.repository;

import com.pahanaedu.billingsystem.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}

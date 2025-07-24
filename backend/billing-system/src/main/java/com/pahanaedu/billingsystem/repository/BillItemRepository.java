package com.pahanaedu.billingsystem.repository;

import com.pahanaedu.billingsystem.model.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillItemRepository extends JpaRepository<BillItem, Long> {
}

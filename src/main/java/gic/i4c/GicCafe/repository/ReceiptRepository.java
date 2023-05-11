package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    
}

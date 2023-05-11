package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    
}

package gic.i4c.GicCafe.service;

import gic.i4c.GicCafe.model.Invoice;

public interface InvoiceService {
    Integer getNewInvoiceNumber();
    Invoice saveInvoice( Invoice invoice );
    Invoice getInvoiceById( Integer id);
}

package gic.i4c.GicCafe.service.ServiceImplements;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Invoice;
import gic.i4c.GicCafe.repository.InvoiceRepository;
import gic.i4c.GicCafe.service.InvoiceService;

@Service
public class InvoiceServiceImplement implements InvoiceService {
    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImplement(InvoiceRepository invoiceRepository) {
        super();
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public Integer getNewInvoiceNumber() {
        Integer newNumber = (int) invoiceRepository.count();
        while (newNumber > 100){
            newNumber = newNumber - 100;
        }
        newNumber = newNumber + 1;

        return newNumber;
    }


    @Override
    public Invoice saveInvoice( Invoice invoice) {
        return invoiceRepository.save(invoice);
    }


    @Override
    public Invoice getInvoiceById(Integer id) {
        return invoiceRepository.findById(id).get();
    }
    
}

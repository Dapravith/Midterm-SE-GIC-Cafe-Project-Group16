package gic.i4c.GicCafe.service.ServiceImplements;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Receipt;
import gic.i4c.GicCafe.repository.ReceiptRepository;
import gic.i4c.GicCafe.service.ReceiptService;

@Service
public class ReceiptServiceImplement implements ReceiptService {
    private ReceiptRepository receiptRepository;

    public ReceiptServiceImplement(ReceiptRepository receiptRepository) {
        super();
        this.receiptRepository = receiptRepository;
    }

    
    @Override
    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }
    
}

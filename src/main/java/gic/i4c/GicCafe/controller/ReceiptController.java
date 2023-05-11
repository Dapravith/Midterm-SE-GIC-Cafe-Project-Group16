package gic.i4c.GicCafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gic.i4c.GicCafe.model.Receipt;
import gic.i4c.GicCafe.service.ReceiptService;

@Controller
public class ReceiptController {
    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        super();
        this.receiptService = receiptService;
    }

    @PostMapping("/check/save_Receipt")
    public String saveReceipt(@ModelAttribute("Receipt") Receipt receipt){
        receiptService.saveReceipt(receipt);
        return "redirect:/checkout/Receipt";
    }

    @GetMapping("/checkout/Receipt")
    public String printReceipt(){
        return "Receipt";
    }

}


package gic.i4c.GicCafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gic.i4c.GicCafe.model.Invoice;
import gic.i4c.GicCafe.model.Receipt;
import gic.i4c.GicCafe.service.InvoiceService;
import gic.i4c.GicCafe.service.TableService;


@Controller
public class InvoiceController {
    private InvoiceService invoiceService;
    private TableService tableService;

    public InvoiceController(InvoiceService invoiceService, TableService tableService) {
        super();
        this.invoiceService = invoiceService;
        this.tableService = tableService;
    }

    @PostMapping("/checkout/saveInvoice")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice, Model model) {
        tableService.setTableUnavailable(invoice.getTable_id());

        invoiceService.saveInvoice(invoice);

        String destination = "redirect:/change_calculation/" + invoice.getId();
        return destination;
    }

    @GetMapping("/change_calculation/{invoiceID}")
    public String calculateChange(Model model, @PathVariable Integer invoiceID) {

        Receipt receipt = new Receipt();
        receipt.setIncoice_id(invoiceID);

        model.addAttribute("receipt", receipt);
        model.addAttribute("total", invoiceService.getInvoiceById(invoiceID).getPrice());
        return "calculateChange";
    }
}
package gic.i4c.GicCafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gic.i4c.GicCafe.model.Invoice;
import gic.i4c.GicCafe.service.CurrentProductOrderService;
import gic.i4c.GicCafe.service.InvoiceService;
import gic.i4c.GicCafe.service.TableService;

@Controller
public class TableController {
    private TableService tableService;
    private CurrentProductOrderService currentDrinkOrderService;
    private InvoiceService invoiceService;

    public TableController(TableService tableService, CurrentProductOrderService currentDrinkOrderService, InvoiceService invoiceService) {
        super();
        this.tableService = tableService;
        this.currentDrinkOrderService = currentDrinkOrderService;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/table_management")
    public String manageTable(Model model){
        model.addAttribute("tableAmount", tableService.getTableAmount());
        return "tableManagement";
    }
    
    @GetMapping("/checkout/table_selection")
    public String selectTable(Model model){
        Invoice newInvoice = new Invoice();
        newInvoice.setDrink_order_ids(currentDrinkOrderService.getAllOrderIds());
        newInvoice.setNumber(invoiceService.getNewInvoiceNumber());
        newInvoice.setPrice(currentDrinkOrderService.getTotalPrice());
        model.addAttribute("invoice", newInvoice);
        model.addAttribute("tables", tableService.getAllTable());
        return "tableSelection";
    }

    @PostMapping("/table_management/set_number_of_table")
    public String setTableAmount(@RequestParam("tableAmount") Integer tableAmount){
        tableService.setNewTableAmount(tableAmount);
        return "redirect:/table_management";
    }

    @PostMapping("/tableAvailability/edit")
    public String setTableAvailable(@RequestParam("tableID") Integer tableID){
        tableService.setTableAvailable(tableID);
        return "redirect:/checkout/table_selection";
    }
}

package gic.i4c.GicCafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gic.i4c.GicCafe.info.OrderInformation;
import gic.i4c.GicCafe.model.Current_product_order;
import gic.i4c.GicCafe.model.Receipt;
import gic.i4c.GicCafe.service.InvoiceService;
import gic.i4c.GicCafe.service.ReceiptService;
import gic.i4c.GicCafe.service.CurrentProductOrderService;
import gic.i4c.GicCafe.service.ProductService;
import gic.i4c.GicCafe.service.ProductSizeService;
@Controller
public class ReceiptController {
    private ReceiptService receiptService;
    private InvoiceService invoiceService;
    private CurrentProductOrderService currentProductOrderService;
    private ProductService productService;
    private ProductSizeService productSizeService;

    public ReceiptController(ReceiptService receiptService, InvoiceService invoiceService,
            CurrentProductOrderService currentProductOrderService, ProductService productService,
            ProductSizeService productSizeService) {
        super();
        this.receiptService = receiptService;
        this.invoiceService = invoiceService;
        this.currentProductOrderService = currentProductOrderService;
        this.productService = productService;
        this.productSizeService = productSizeService;
    }

    @PostMapping("/receipt/save")
    public String saveReceipt(@ModelAttribute("receipt") Receipt receipt) {
        receiptService.saveReceipt(receipt);
        String destination = "redirect:/receipt/" + receipt.getInvoice_id();
        return destination;
    }

    @GetMapping("/receipt/{invoiceId}")
    public String printReceipt(@PathVariable Integer invoiceId, Model model) {
        model.addAttribute("invoice", invoiceService.getInvoiceById(invoiceId));

        List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
        for (Current_product_order order : currentProductOrderService.getAllOrders()) {
            orderInfos.add(new OrderInfo(productService.getProductById(order.getProduct_id()),
                    productSizeService.getSizeById(order.getSize_id()),
                    currentProductOrderService.getOrderById(order.getId())));
        }
        model.addAttribute("allOrders", orderInfos);

        return "PrintReceipt";
    }

}

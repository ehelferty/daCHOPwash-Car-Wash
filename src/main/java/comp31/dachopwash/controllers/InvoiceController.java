package comp31.dachopwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.dachopwash.services.InvoiceService;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired InvoiceService invoiceService;

    @GetMapping("")
    public String getInvoices(@RequestParam(required=false, name="id") String invoiceId, Model model)
    {

        if (invoiceId != null) {
            model.addAttribute("invoice", invoiceService.findInvoiceById(Integer.parseInt(invoiceId)));
            return "payment";
        }

        model.addAttribute("invoices", invoiceService.findInvoices());
        return "invoices";
    }
}

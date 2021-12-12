package comp31.dachopwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.dachopwash.services.InvoiceService;
import comp31.dachopwash.models.formentities.PaymentFormModel;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired InvoiceService invoiceService;

    @GetMapping("")
    public String getInvoices(
        @RequestParam(required=false, name="id") String invoiceId, 
        @RequestParam(required=false, name="unpaidOnly") Boolean unpaidOnly,
        Model model)
    {

        if (invoiceId != null) {
            model.addAttribute("invoice", invoiceService.findInvoiceById(Integer.parseInt(invoiceId)));
            model.addAttribute("paymentForm", new PaymentFormModel());
            return "payment";
        }

        if (unpaidOnly != null && unpaidOnly == true) {
            model.addAttribute("invoices", invoiceService.findOutstandingInvoices());
            return "invoices";
        }

        model.addAttribute("invoices", invoiceService.findInvoices());
        return "invoices";
    }

    @PostMapping("")
    public String addPayment(
        @ModelAttribute PaymentFormModel paymentInfo,
        Model model)
        {
            invoiceService.createPayment(paymentInfo.getInvoiceId(), paymentInfo.getPayment());
            return "invoices";
        }

    @GetMapping("/payments")
    public String getPayments(Model model)
    {

        model.addAttribute("payments", invoiceService.findPayments());
        return "payments";
    }
}

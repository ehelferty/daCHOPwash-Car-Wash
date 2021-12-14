package comp31.dachopwash.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.dachopwash.models.entities.Invoice;
import comp31.dachopwash.models.entities.Payment;
import comp31.dachopwash.models.repositories.InvoiceRepo;
import comp31.dachopwash.models.repositories.PaymentRepo;
import lombok.Data;

@Service
@Data
public class InvoiceService {

    InvoiceRepo invoiceRepo;
    PaymentRepo paymentRepo;

    @Autowired
    public InvoiceService(InvoiceRepo invoiceRepo, PaymentRepo paymentRepo) {
        super();
        this.invoiceRepo = invoiceRepo;
        this.paymentRepo = paymentRepo;
    }
    
    public List<Invoice> findInvoices() {
        List<Invoice> invoiceList = invoiceRepo.findAll();
        return invoiceList;
    }

    public List<Invoice> findOutstandingInvoices() {
        List<Invoice> invoiceList = invoiceRepo.findInvoiceByinvoiceBalanceGreaterThan(0.);
        return invoiceList;
    }

    public Invoice findInvoiceById(Integer invoiceID) {
        return invoiceRepo.findInvoiceByinvoiceID(invoiceID);
    }

    public void createPayment(Integer invoiceID, Double payment) {
        Payment newPayment = new Payment();
        Invoice invoice = invoiceRepo.findInvoiceByinvoiceID(invoiceID);
        newPayment.setInvoice(invoice);
        newPayment.setPaymentAmount(payment);
        paymentRepo.save(newPayment);
        invoice.setInvoiceBalance(invoice.getInvoiceBalance() - payment);
        invoiceRepo.save(invoice);
    }

    public List<Payment> findPayments() {
        List<Payment> paymentList = paymentRepo.findAll();
        return paymentList;
    }
}

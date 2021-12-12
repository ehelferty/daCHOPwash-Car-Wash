package comp31.dachopwash.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.dachopwash.models.entities.Invoice;
import comp31.dachopwash.models.repositories.InvoiceRepo;
import lombok.Data;

@Service
@Data
public class InvoiceService {

    InvoiceRepo invoiceRepo;

    @Autowired
    public InvoiceService(InvoiceRepo invoiceRepo) {
        super();
        this.invoiceRepo = invoiceRepo;
    }

    Invoice invoice;
    
    public List<Invoice> findInvoices() {
        List<Invoice> invoiceList = invoiceRepo.findAll();
        return invoiceList;
    }

    public Invoice findInvoiceById(Integer invoiceID) {
        return invoiceRepo.findInvoiceByinvoiceID(invoiceID);
    }
}

package comp31.dachopwash.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.dachopwash.models.repositories.InvoiceRepo;

@Service
public class InvoiceService {

    InvoiceRepo invoiceRepo;

    @Autowired
    public InvoiceService(InvoiceRepo invoiceRepo) {
        super();
        this.invoiceRepo = invoiceRepo;
    }
    
}

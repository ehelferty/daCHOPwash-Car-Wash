package comp31.dachopwash.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.dachopwash.models.entities.Invoice;

@Repository
public interface InvoiceRepo extends CrudRepository<Invoice, Integer>{
    List<Invoice> findAll();
    Invoice findInvoiceByinvoiceID(Integer invoiceID);
}

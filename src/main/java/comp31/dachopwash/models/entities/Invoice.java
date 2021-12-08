package comp31.dachopwash.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;

@Entity
@Data
@Table(name="Invoice")
public class Invoice {
    
    @Id
    @Column(name="Invoice_ID")
    private Integer InvoiceID;

    @OneToOne
    @JoinColumn(name="Wash_ID")
    private Wash wash;

    @OneToOne
    @JoinColumn(name="Customer_ID")
    private Customer customer;

    @Column(name="Invoice_Total")
    private Double invoiceTotal;

    @Column(name="Invoice_Balance")
    private Double invoiceBalance;

    @Column(name="Created_Date")
    private Date createdDate;

    @Column(name="Paid_Date")
    private Date paidDate;


}

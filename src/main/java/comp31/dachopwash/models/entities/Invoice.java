package comp31.dachopwash.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;

@Entity
@Data
@Table(name="Invoice")
public class Invoice {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Invoice_ID")
    private Integer invoiceID;

    @OneToOne
    @JoinColumn(name="Wash_ID")
    private Wash wash;

    @ManyToOne
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

package comp31.dachopwash.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;

@Entity
@Data
@Table(name="Invoice")
public class Invoice {
    
    @Id
    @Column(name="Wash_ID")
    private Integer washID;

    @Column(name="Customer_ID")
    private Integer customerID;

    @Column(name="Invoice_Total")
    private Double invoiceTotal;

    @Column(name="Invoice_Balance")
    private Double invoiceBalance;

    @Column(name="Created_Date")
    private Date createdDate;

    @Column(name="Paid_Date")
    private Date paidDate;


}

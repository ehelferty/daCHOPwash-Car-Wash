package comp31.dachopwash.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Payment")
public class Payment {
    
    @Id
    @Column(name="Payment_ID")
    private Integer paymentID;

    @ManyToOne
    @JoinColumn(name="Invoice_ID")
    private Invoice invoice;

    @Column(name="Payment_Amount")
    private Double paymentAmount;

}

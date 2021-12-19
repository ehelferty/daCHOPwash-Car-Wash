package comp31.dachopwash.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CUSTOMER")
public class Customer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ID")
    Integer customerId;

    @Column(name="CUSTOMER_FIRST_NAME")
    String customerFirstName;

    @Column(name="CUSTOMER_LAST_NAME")
    String customerLastName;
}

package comp31.dachopwash.models.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="WASH")
public class Wash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WASH_ID")
    private Integer washId;
    
    @Column(name="WASH_TYPE")
    private Integer washType;

    @Column(name="WASH_STATUS")
    private Integer washStatus;

    @ManyToOne()
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
}
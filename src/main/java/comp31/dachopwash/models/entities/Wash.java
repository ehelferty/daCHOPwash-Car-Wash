package comp31.dachopwash.models.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="WASH")
public class Wash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WASH_ID")
    private Integer washID;
    
    @Column(name="WASH_TYPE")
    private Integer washType;

    @Column(name="WASH_STATUS")
    private Integer washStatus;

    @OneToOne(mappedBy = "wash")
    private Employee employee;

    @OneToOne(mappedBy = "wash")
    private Customer customer;
}
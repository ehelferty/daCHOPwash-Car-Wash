package comp31.dachopwash.models.formentities;

import java.util.UUID;

import comp31.dachopwash.models.entities.Customer;
import comp31.dachopwash.models.entities.Employee;
import lombok.Data;
import lombok.Getter;

/**
 * Model describing Wash data
 */
@Data 
public class WashModel {
    
    @Getter
    Long washId;

    Integer washType;
    Integer washStatus;
    Employee employee;
    Customer customer;

    /**
     * Sets a wash ID
     */
    public WashModel() {
        washId = UUID.randomUUID().getLeastSignificantBits() & 0xFFFFFF;
    }

    /**
     * Creates a new wash with supplied data
     * @param washType
     * @param washStatus
     * @param employee
     * @param customer
     */
    public WashModel(Integer washType, Integer washStatus, Employee employee, Customer customer) {
        this();
        this.washType= washType;
        this.washStatus= washStatus;
        this.employee= employee;
        this.customer= customer;
    }

}

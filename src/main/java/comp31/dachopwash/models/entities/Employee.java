package comp31.dachopwash.models.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="EMPLOYEE")
public class Employee{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    Integer employeeId;

    @Column(name = "EMPLOYEE_ROLE")
    String employeeRole;

    @Column(name = "EMPLOYEE_FIRST_NAME")
    String employeeFirstName;

    @Column(name = "EMPLOYEE_LAST_NAME")
    String employeeLastName;

    @Column(name = "EMPLOYEE_HIRE_DATE")
    LocalDate employeeStartDate;

    @Column(name = "EMPLOYEE_TERMINATION_DATE", nullable = true)
    LocalDate employeeEndDate;

    @Column(name = "EMPLOYEE_SALARY")
    double employeeSalary;
    
    
}

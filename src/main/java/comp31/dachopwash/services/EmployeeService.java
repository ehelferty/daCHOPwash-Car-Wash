package comp31.dachopwash.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import comp31.dachopwash.models.entities.Employee;
import comp31.dachopwash.models.repositories.EmployeeRepo;
import lombok.Data;

@Service
@Data
public class EmployeeService {
    
    EmployeeRepo employeeRepo;
    //WashRepo washRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo/*, WashRepo washRepo*/){
        super();
        this.employeeRepo = employeeRepo;
        //this.washRepo = washRepo;
    }

    Employee employee;

    public List<Employee> findEmployees(){
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList;
    }

    // public void addEmployee(String firstName, String lastName, String role){
    //     // DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
    //     // LocalDate startDate = LocalDate.parse(employeeStartDate, formatter);
        
    //     employee = new Employee();
    //     employee.setEmployeeFirstName(firstName);
    //     employee.setEmployeeLastName(lastName);
    //     employee.setEmployeeRole(role);
    //     employeeRepo.save(employee);
    // }
}

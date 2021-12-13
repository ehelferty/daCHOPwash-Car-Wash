package comp31.dachopwash.services;

import java.time.LocalDate;
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

    public void createEmployee(String firstName, String lastName, String roleTitle, LocalDate startDate, double salary){
        employee = new Employee();
        employee.setEmployeeFirstName(firstName);
        employee.setEmployeeLastName(lastName);
        employee.setEmployeeRole(roleTitle);
        employee.setEmployeeStartDate(startDate);
        employee.setEmployeeSalary(salary);

        employeeRepo.save(employee);
    }

    public Employee findById(Integer id){
        employee = employeeRepo.findByEmployeeId(id);
        return employee;
    }

    public void fireEmployee(Integer empId){
        employee = findById(empId);
        employee.setEmployeeEndDate(LocalDate.now());
    }


}

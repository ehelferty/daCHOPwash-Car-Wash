package comp31.dachopwash.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.dachopwash.entities.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer>{
    List<Employee> findAll();
    List<Employee> findByEmployeeRole(String role);
    Employee findByEmployeeFirstName(String firstName);
    Employee findByEmployeeLastName(String lastName);

}

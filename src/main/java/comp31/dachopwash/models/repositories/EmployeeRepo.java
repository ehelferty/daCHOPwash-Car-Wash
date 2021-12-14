package comp31.dachopwash.models.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.dachopwash.models.entities.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer>{
    List<Employee> findAll();
    List<Employee> findByEmployeeRole(String role);
    Employee findByEmployeeId(Integer employeeId);
    Employee findByEmployeeFirstName(String firstName);
    Employee findByEmployeeLastName(String lastName);

}

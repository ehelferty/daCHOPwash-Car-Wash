package comp31.dachopwash.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.dachopwash.models.entities.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer>{
    List<Customer> findAll();
    
}

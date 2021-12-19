package comp31.dachopwash.models.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.dachopwash.models.entities.Payment;

@Repository
public interface PaymentRepo extends CrudRepository<Payment, Integer> {
    List<Payment> findAll();
 
}

package comp31.dachopwash.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.dachopwash.models.entities.Wash;

@Repository
public interface WashRepo extends CrudRepository<Wash,Long> {
    Wash findByWashId(Integer washId);
}
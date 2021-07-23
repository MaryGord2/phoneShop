package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.client;

@Repository
public interface ClientRepository extends CrudRepository<client, Long>{
}

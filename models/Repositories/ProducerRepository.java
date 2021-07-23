package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.producer;

@Repository
public interface ProducerRepository extends CrudRepository<producer, Long> {
}

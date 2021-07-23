package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.dolznost;

@Repository
public interface DolznostRepository extends CrudRepository<dolznost, Long> {
}

package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.accumul;

@Repository
public interface AccumRepository extends CrudRepository<accumul, Long> {
}

package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.typeDispl;

@Repository
public interface TypeDispRepository extends CrudRepository<typeDispl, Long> {
}

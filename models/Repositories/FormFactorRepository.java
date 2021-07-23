package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.formFactor;

@Repository
public interface FormFactorRepository extends CrudRepository<formFactor, Long> {
}

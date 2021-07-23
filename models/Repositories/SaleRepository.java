package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.accumul;
import ru.specialist.demo.models.sale;

@Repository
public interface SaleRepository extends CrudRepository<sale, Long> {
}

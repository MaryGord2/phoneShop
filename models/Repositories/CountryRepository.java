package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.country;

@Repository
public interface CountryRepository extends CrudRepository<country, Long> {
}

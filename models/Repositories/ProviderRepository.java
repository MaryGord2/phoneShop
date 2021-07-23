package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.provider;

@Repository
public interface ProviderRepository extends CrudRepository<provider, Long> {
}

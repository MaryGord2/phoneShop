package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.os;

@Repository
public interface OsRepository extends CrudRepository<os, Long> {
}

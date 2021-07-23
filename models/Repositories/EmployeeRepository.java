package ru.specialist.demo.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.specialist.demo.models.employee;

@Repository
public interface EmployeeRepository extends CrudRepository<employee, Long> {
}

package company.app.Company.repositories;

import company.app.Company.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> deleteById (Long id);
}

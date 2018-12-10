package company.app.Company.repositories;

import company.app.Company.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> deleteById(Long id);

    List<Employee> findByName(String name);

    List<Employee> findBySurname(String surname);

    List<Employee> findByMail(String mail);

    @Query(value = "select new map(e.job as job, count(e) as count ) from Employee e group by e.job")
    List<?> findDistinctCountByJob();
}

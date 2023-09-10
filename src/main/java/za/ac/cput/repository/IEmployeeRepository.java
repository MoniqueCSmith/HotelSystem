package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.HotelLocation;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
}

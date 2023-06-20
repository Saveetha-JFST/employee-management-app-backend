package com.saveetha.employee.emp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("Select e from Employee e where e.employeeEmail=?1")
    Optional<Employee> findEmployeeByEmail(String employeeEmail);
}

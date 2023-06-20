package com.saveetha.employee.emp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> fetchEmployees()
    {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findEmployeeByEmail(employee.getEmployeeEmail());

        if (existingEmployee.isPresent())
        {
            throw new IllegalStateException("Email already used");
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeID) {
        boolean employeeExists = employeeRepository.existsById(employeeID);

        if (!employeeExists)
        {
            throw new IllegalStateException("Employee with ID " + employeeID + " doesn't exists");
        }
        employeeRepository.deleteById(employeeID);
    }
}

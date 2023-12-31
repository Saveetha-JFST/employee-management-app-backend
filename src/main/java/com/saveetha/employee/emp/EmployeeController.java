package com.saveetha.employee.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> getEmployees()
    {
        return employeeService.fetchEmployees();
    }

    @PostMapping("/")
    public void postEmployees(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @DeleteMapping(path={"/{id}"})
    public void deleteEmployees(@PathVariable("id") Long employeeID)
    {
        employeeService.deleteEmployee(employeeID);
        System.out.println(employeeID);
    }
}

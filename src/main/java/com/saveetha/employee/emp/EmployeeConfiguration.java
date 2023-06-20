package com.saveetha.employee.emp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee sethu = new Employee(
                    "Sethu",
                    LocalDate.of(2020, Month.NOVEMBER, 1),
                    "sethu@prograd.org"
            );

            Employee ravichandran = new Employee(
                    "Ravichandran",
                    LocalDate.of(2020, Month.NOVEMBER, 1),
                    "ravichandran@prograd.org"
            );

            employeeRepository.saveAll(
                    List.of(sethu, ravichandran)
            );
        };
    }

}

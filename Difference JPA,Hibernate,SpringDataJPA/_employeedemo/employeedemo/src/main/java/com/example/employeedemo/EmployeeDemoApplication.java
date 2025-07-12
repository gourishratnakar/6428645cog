package com.example.employeedemo;

import com.example.employeedemo.model.Employee;
import com.example.employeedemo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repo) {
        return args -> {
            // Save a few employee records
            repo.save(new Employee("John", "IT", 50000));
            repo.save(new Employee("Priya", "HR", 60000));
            repo.save(new Employee("Ravi", "Finance", 55000));

            // Print all employees
            System.out.println("All Employees:");
            repo.findAll().forEach(emp ->
                System.out.println(emp.getId() + ": " + emp.getName() + " - " + emp.getDepartment() + " - ₹" + emp.getSalary())
            );

            // Print employees in a specific department
            System.out.println("\nHR Employees:");
            repo.findByDepartment("HR").forEach(emp ->
                System.out.println(emp.getName())
            );
        };
    }
}

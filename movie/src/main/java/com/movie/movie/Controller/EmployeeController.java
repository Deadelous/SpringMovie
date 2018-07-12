package com.movie.movie.Controller;

import com.movie.movie.Exception.ResourceNotFoundException;
import com.movie.movie.Model.Employee;
import com.movie.movie.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/Employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/Employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/Employees/{id}")
    public Employee getEmployeeId(@PathVariable(value = "id") Long employeeId){
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    @PutMapping("/Employees/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
                             @Valid @RequestBody Employee employeeDetails) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        employee.setEmployeeName(employeeDetails.getEmployeeName());

        Employee updatedEmployee= employeeRepository.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("/Employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        Employee store = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        employeeRepository.delete(store);

        return ResponseEntity.ok().build();
    }
}

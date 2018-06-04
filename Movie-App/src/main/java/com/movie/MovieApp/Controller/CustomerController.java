package com.movie.MovieApp.Controller;

import com.movie.MovieApp.Exception.ResourceNotFoundException;
import com.movie.MovieApp.Model.Customer;
import com.movie.MovieApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/Customers")
    public List<Customer> getAllEmployees(){
        return customerRepository.findAll();
    }

    @PostMapping("/Customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/Customers/{id}")
    public Customer getCustomerId(@PathVariable(value = "id") Long customerId){
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
    }

    @PutMapping("/Customers{id}")
    public Customer updateCustomer(@PathVariable(value = "id") Long customerId,
                                   @Valid @RequestBody Customer customerDetails) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

        customer.setCustomerAdress(customerDetails.getCustomerAdress());
        customer.setCustomerName(customerDetails.getCustomerName());

        Customer updatedEmployee= customerRepository.save(customer);
        return updatedEmployee;
    }

    @DeleteMapping("/Customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));


        customerRepository.delete(customer);

        System.out.println("delete customer");
        return ResponseEntity.ok().build();

    }
}

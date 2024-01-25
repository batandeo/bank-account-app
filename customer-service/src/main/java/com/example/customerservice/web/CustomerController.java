package com.example.customerservice.web;

import com.example.customerservice.entites.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

}

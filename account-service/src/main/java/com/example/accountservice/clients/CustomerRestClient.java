package com.example.accountservice.clients;

import com.example.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name="customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/api/customers")
    @CircuitBreaker(name="customerService",fallbackMethod = "getAlltCustomer")
    List<Customer> allCustomers();
    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstname("Not available");
        customer.setLastname("Not available");
        customer.setEmail("Not available");
        return customer;

    }

    default List<Customer> getAlltCustomer(Exception exception){
        return List.of();
    }
}

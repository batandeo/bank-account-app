package com.example.accountservice.web;

import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entites.BankAccount;
import com.example.accountservice.model.Customer;
import com.example.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BankAccountController {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    public BankAccountController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount customerById(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomer_id());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }


}

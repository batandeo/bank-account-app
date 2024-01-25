package com.example.accountservice;

import com.example.accountservice.entites.BankAccount;
import com.example.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.rmi.server.UID;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
//activation de open feignClient
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {
            List<BankAccount> customerList= Arrays.asList(BankAccount.builder()
                            .accountId(UUID.randomUUID().toString()).
                            currency("MAD").
                    customer_id(Long.valueOf(1)).
                            build(),
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString()).
                            currency("MAD2").
                            customer_id(Long.valueOf(2)).
                            build()
            );
            bankAccountRepository.saveAll(customerList);
        };
    }
}

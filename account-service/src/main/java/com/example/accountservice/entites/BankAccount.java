package com.example.accountservice.entites;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate localDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long customer_id;
    @Transient
    private Customer customer;
}

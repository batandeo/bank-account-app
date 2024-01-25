package com.example.customerservice;

import com.example.customerservice.config.GlobalConfig;
import com.example.customerservice.entites.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList= Arrays.asList(Customer.builder()
					.firstname("BATANDEO").
					lastname("Baoura").build(),
					Customer.builder().firstname("Alain").
							lastname("DOPKA").build()
					);
			customerRepository.saveAll(customerList);
		};
	}

}

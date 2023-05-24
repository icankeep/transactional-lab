package com.example.transactionallab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class TransactionalLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalLabApplication.class, args);
    }

}

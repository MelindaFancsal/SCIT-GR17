package org.example.JDBC.jdbc;

import org.example.JDBC.jdbc.db.PostgreSQLDb;
import org.example.JDBC.jdbc.models.Customer;
import org.example.JDBC.jdbc.repo.CustomerRepository;
import org.example.JDBC.jdbc.sql.SQLCustomerDAOImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository(new SQLCustomerDAOImpl(new PostgreSQLDb()));

        List<Customer> customerList = customerRepository.getAllCustomers();

        customerList.forEach(it -> {
            Thread thread = new Thread(() -> {
                System.out.println("Thead name : " + Thread.currentThread().getName() + " " + it.getFirstName());
            });

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}

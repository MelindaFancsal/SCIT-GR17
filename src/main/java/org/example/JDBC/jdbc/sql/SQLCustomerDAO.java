package org.example.JDBC.jdbc.sql;

import org.example.JDBC.jdbc.models.Customer;

import java.util.List;

public interface SQLCustomerDAO {
    List<Customer> getAll();
    void add(Customer customer);

    void delete(int customerId);

    void update(Customer customer);
}

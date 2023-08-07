package org.example.JDBC.jdbc.repo;

import org.example.JDBC.jdbc.models.Customer;
import org.example.JDBC.jdbc.sql.SQLCustomerDAO;

import java.util.List;

public class CustomerRepository {

    private SQLCustomerDAO sqlOderDAO;

    public CustomerRepository(SQLCustomerDAO customerDAO) {
        this.sqlOderDAO = customerDAO;
    }

    public List<Customer> getAllCustomers() {
        //aducerea info de la server
        //salvars lor in db
        return sqlOderDAO.getAll();
    }

    public void signUp(Customer customer) {
        //o salvez in baza de date
        sqlOderDAO.add(customer);
    }

    public void unregisterCustomer(Customer customer) {
        sqlOderDAO.delete(customer.getId());
    }

}

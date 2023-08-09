package org.example.JDBC.jdbc.sql;

import org.example.JDBC.jdbc.db.ConnectDB;
import org.example.JDBC.jdbc.models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLCustomerDAOImpl implements SQLCustomerDAO {

    private ConnectDB db;

    public SQLCustomerDAOImpl(ConnectDB db) {
        this.db = db;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = db.connect()) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from customer");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");

                customers.add(new Customer(id, firstName, lastName, address));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customers;
    }

    @Override
    public void add(Customer customer) {

        try (Connection connection = db.connect()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into customer(first_name, last_name, address) values (?,?,?)"
            );
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getAddress());

            statement.executeUpdate();


            Statement statementData = connection.createStatement();
            ResultSet resultSet = statementData.executeQuery("SELECT CURRVAL('client_ids')");
            resultSet.next();
            customer.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(int customerId) {

    }

    @Override
    public void update(Customer customer) {
        try (Connection connection = db.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE customer SET first_name = '" + customer.getFirstName() + "', address = '" + customer.getAddress() + "' WHERE id = " + customer.getId() + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

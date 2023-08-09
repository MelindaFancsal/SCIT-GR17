package org.example.JDBC.jdbc.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class PostgreSQLDbTest extends PostgreSQLDb{

    // Creates a connection to the PostgreSQL without selecting a database

    @Override
    public Connection connect()  {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection connection = null;
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")       // “mysql” / “db2” / “mssql” / “oracle” / ...
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("postgres")
                    .append("?user=")
                    .append("postgres")
                    .append("&password=")
                    .append("melinda").toString();
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new PostgresSQLDBException("Could not load DB driver."+e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setUpTestDB()  {
        PostgreSQLDb tdb = new PostgreSQLDb();
        try(Connection connection = tdb.connect()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE customers_test_2;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // connect to newly created tests database and create tables.
        try(Connection connection = tdb.connect()) {
            StringBuilder builder = new StringBuilder();
            builder.append("CREATE SEQUENCE customers_ids;");
            builder.append("CREATE TABLE customers(id INT PRIMARY KEY DEFAULT NEXTVAL('customers_ids'), name VARCHAR(50) NOT NULL, address VARCHAR(100) NOT NULL);");
            builder.append("CREATE SEQUENCE orders_nrs;");
            builder.append("CREATE TABLE orders(id INT PRIMARY KEY DEFAULT NEXTVAL('orders_nrs'), phoneNr VARCHAR(12), clientId INT REFERENCES customers(id));");
            builder.append("CREATE SEQUENCE car_ids;");
            builder.append("CREATE TABLE cars(id INT PRIMARY KEY DEFAULT NEXTVAL('car_ids'), name VARCHAR(50), manufacturer VARCHAR(50));");
            builder.append("CREATE SEQUENCE order_ids;");
            builder.append("CREATE TABLE orders(id INT PRIMARY KEY DEFAULT NEXTVAL('order_ids'), carId INT REFERENCES cars(id), price INT, clientId INT REFERENCES customers(id));");

            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(builder.toString());

            statement.execute("CREATE OR REPLACE FUNCTION list_customers(ref refcursor) RETURNS refcursor AS $$ "
                    + " BEGIN "
                    + " OPEN ref FOR SELECT namex, address FROM customers;"
                    + " RETURN ref;"
                    + "END;"
                    + " $$ LANGUAGE plpgsql;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dropTestDB()  {
        PostgreSQLDb tdb = new PostgreSQLDb();
        try(Connection connection = tdb.connect()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP DATABASE orders_test_2;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropDataFromTables()  {
        try(Connection connection = connect()){
            StringBuilder builder = new StringBuilder();
            builder.append("DELETE FROM orders;");
            builder.append("DELETE FROM customers;");

            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(builder.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
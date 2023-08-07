package org.example.JDBC.jdbc;


import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver").newInstance();

            DriverManager.setLoginTimeout(60); // wait 1 min; optional: database may be busy, good to set a higher timeout

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

            try (Connection connection = DriverManager.getConnection(url);
                 Statement s = connection.createStatement();
                 ResultSet resultSet = s.executeQuery("SELECT * from customer;")) {

                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt("id") + ", name: " + resultSet.getString("last_name"));
                }

            } catch (SQLException e) {
                System.err.println("Cannot connect to the database: " + e.getMessage());
            }

        } catch (ClassNotFoundException | RuntimeException | IllegalAccessException | InstantiationException e) {
            System.out.println("CANNOT LOAD DRIVER");
        }
    }
}

package org.example.JDBC.jdbc.db;

import java.sql.*;

public class PostgreSQLDb implements ConnectDB {

    @Override
    public Connection connect() {
        Connection connection = null;

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

            connection = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new PostgresSQLDBException(e.getMessage());
        }

        return connection;
    }
}

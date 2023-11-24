package com.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/session08";
    private static final String USER = "root";
    private static final String PASSWORD = "11111111";

    // tao phuong thuc mo ket noi
    public static Connection openConnection() {
        Connection connection = null;
        try {
            // dang ki drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            // lay ket noi
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    // phuong thuc mo
    // public static void main(String[] args) {
    // System.out.println(ConnectionDB.openConnection());
    // }

    // phuong thuc dong ket noi
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

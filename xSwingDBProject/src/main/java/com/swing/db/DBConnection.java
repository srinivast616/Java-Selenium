package com.swing.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/swingdb", "root", "Tamtam@1981"); // change password if any
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


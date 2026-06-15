package com.sample.pagefactory.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBReader {

    public void readFromDatabase() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.sample.pagefactory.utils;

import java.sql.*;

public class DBUtils {	

    public static void readDB(String query) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user", "password");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             while (rs.next()) {
                System.out.println(rs.getString(1)); // customize as needed
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

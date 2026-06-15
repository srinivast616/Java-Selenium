package com.sample.pagefactory.utils;

import java.sql.*;

public class DBUtils {	
	
	private static final String URL = ConfigReader.get("db.url");
    private static final String USER = ConfigReader.get("db.username");
    private static final String PASSWORD = ConfigReader.get("db.password");
	
	public static void checkDBConnection() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (conn != null) System.out.println("DB Connected");
        } catch (SQLException e) {
            throw new RuntimeException("DB connection failed", e);
        }
	}

    public static void readDB(String query) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
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

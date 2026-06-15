package com.swing.db;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UserForm extends JFrame {
    JTextField nameField, emailField;
    JButton saveButton, viewButton;
    JTextArea resultArea;

    public UserForm() {
        setTitle("User Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 30, 200, 30);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 70, 200, 30);
        add(emailField);

        saveButton = new JButton("Save");
        saveButton.setBounds(100, 110, 80, 30);
        add(saveButton);

        viewButton = new JButton("View All");
        viewButton.setBounds(200, 110, 100, 30);
        add(viewButton);

        resultArea = new JTextArea();
        resultArea.setBounds(30, 150, 320, 100);
        add(resultArea);

        // Save data
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();

            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement stmt = con.prepareStatement("INSERT INTO swing_users(name, email) VALUES (?, ?)");
                stmt.setString(1, name);
                stmt.setString(2, email);
                int i = stmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(this, "Data Saved!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // View data
        viewButton.addActionListener(e -> {
            try (Connection con = DBConnection.getConnection()) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM swing_users");
                StringBuilder sb = new StringBuilder();
                while (rs.next()) {
                    sb.append(rs.getInt("id")).append(": ")
                      .append(rs.getString("name")).append(" - ")
                      .append(rs.getString("email")).append("\n");
                }
                resultArea.setText(sb.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}


package com.jspservlet.studentmanagememt;

import com.jspservlet.studentmanagememt.DBConnection;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO students(name, email) VALUES (?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("view.jsp");
    }
}


package com.jspservlet.studentmanagememt;

import com.jspservlet.studentmanagememt.DBConnection;
import com.jspservlet.studentmanagememt.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("studentList", students);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }
}


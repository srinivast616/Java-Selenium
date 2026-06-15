<%@ page import="java.sql.*" %>
<%@ page import="db.DBConnection" %>

<html>
<head><title>All Students</title></head>
<body>
<h2>All Students</h2>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th></tr>

<%
    Connection con = DBConnection.getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM students");

    while (rs.next()) {
%>
<tr>
    <td><%=rs.getInt("id")%></td>
    <td><%=rs.getString("name")%></td>
    <td><%=rs.getString("email")%></td>
</tr>
<%
    }
%>
</table>
<br><a href="index.jsp">Add New Student</a>
</body>
</html>

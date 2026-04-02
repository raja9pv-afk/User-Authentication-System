<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Register</h2>
<form action="RegisterServlet" method="post">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    Email: <input type="email" name="email" required><br>
    <input type="submit" value="Register">
</form>
<p style="color:red;">
<%= request.getParameter("msg") != null ? request.getParameter("msg") : "" %>
</p>
</body>
</html>
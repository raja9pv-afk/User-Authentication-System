<%@ page language="java" session="true" %>
<html>
<body>
<h2>Welcome <%= session.getAttribute("username") %></h2>
<a href="login.jsp">Logout</a>
</body>
</html>
package com.user;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO login_users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);

            int result = ps.executeUpdate();
            if(result > 0) {
                response.sendRedirect("login.jsp?msg=registered");
            } else {
                response.sendRedirect("register.jsp?msg=error");
            }

        } catch(SQLException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?msg=error");
        } catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
    }
}
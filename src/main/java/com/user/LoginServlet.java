package com.user;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        
         System.out.println("username:"+username);
         System.out.println("password:"+password);

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM login_users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("Login success for: " + username);

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);

                response.sendRedirect("welcome.jsp");
            } else {
                System.out.println("Login failed for: " + username);

                response.sendRedirect("login.jsp?msg=invalid");
            }

        } catch(SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?msg=error");
        } catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
    }
}
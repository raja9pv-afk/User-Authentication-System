package com.user;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASS = "tiger"; 

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	 // Load driver (optional but good for learning)
       Class.forName("oracle.jdbc.driver.OracleDriver");//this not req java 8 later
    	
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
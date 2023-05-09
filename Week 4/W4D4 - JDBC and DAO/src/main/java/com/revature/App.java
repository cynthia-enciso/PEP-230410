package com.revature;

import java.sql.*;

import com.revature.dao.PetDAO;
import com.revature.dao.PetDAOImpl;

public class App 
{
    // connection to a database:
    // third-party database driver
    // URL (location of database) & credentials
    public static String url = "jdbc:mysql://localhost:3306/demo1";
    public static String username = "root";
    public static String password = "pass";

    public static void main( String[] args )
    {
        // testConnection();
        PetDAO petDAO = new PetDAOImpl();
        System.out.println(petDAO.getPetById(1));
    }

    public static void testConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is valid: " + connection.isValid(5));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

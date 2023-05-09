package com.revature.dao;

import java.sql.*;

import com.revature.model.Pet;

public class PetDAOImpl implements PetDAO {

    public static String url = "jdbc:mysql://localhost:3306/demo1";
    public static String username = "root";
    public static String password = "pass";

    @Override
    public Pet getPetById(int idToFind) {
        Pet pet = new Pet();

        // interact with database
        // 1. get a connection
        // 2. create a statement
        // 3. execute query
        // 4. process results
        // 5. close connection

        // get and close connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            //create a statement
            String sql = "SELECT * FROM pets WHERE id = " + idToFind;
            Statement statement = connection.createStatement();

            // execute query
            ResultSet rs = statement.executeQuery(sql);

            // process results
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String species = rs.getString("species");
                int vetId = rs.getInt("vet_id");

                pet = new Pet(id, name, age, species, vetId);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pet;
    }
    
}

package com.revature.dao;

import java.sql.*;
import java.util.ArrayList;

import com.revature.model.Pet;
import com.revature.util.ConnectionUtility;

public class PetDAOImpl implements PetDAO {

    @Override
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();

        // get and close connection
        try (Connection connection = ConnectionUtility.getConnection()) {

            //create a statement
            String sql = "SELECT * FROM pets";
            PreparedStatement statement = connection.prepareStatement(sql);

            // execute query
            ResultSet rs = statement.executeQuery();

            // process results
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String species = rs.getString("species");
                int vetId = rs.getInt("vet_id");

                pets.add(new Pet(id, name, age, species, vetId));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pets;
    }
    
    @Override
    public Pet getPetById(int idToFind) {

        // interact with database
        // 1. get a connection
        // 2. create a statement
        // 3. execute query
        // 4. process results
        // 5. close connection

        // get and close connection
        try (Connection connection = ConnectionUtility.getConnection()) {

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

                return new Pet(id, name, age, species, vetId);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Pet addPet(Pet pet) {
        // create a connection and close connection
        try(Connection connection = ConnectionUtility.getConnection()) {
            // sql
            String sql = "INSERT INTO pets VALUES (default, ?, ?, ?, ?)";

            // create a statement
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            // execute statement
            statement.setString(1, pet.getName());
            statement.setInt(2, pet.getAge());
            statement.setString(3, pet.getSpecies());
            statement.setInt(4, pet.getVetId());

            statement.executeUpdate();

            // process results
            ResultSet keys = statement.getGeneratedKeys();

            // if there is a key to return
            if (keys.next()) {
                // getInt(1) gets the first int
                return new Pet(keys.getInt(1), pet.getName(), pet.getAge(), pet.getSpecies(), pet.getVetId());
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }


        return null;
    }
    
}

package com.revature;

import java.sql.*;

import com.revature.dao.PetDAO;
import com.revature.dao.PetDAOImpl;
import com.revature.model.Pet;

public class App 
{


    public static void main( String[] args )
    {
        PetDAO petDAO = new PetDAOImpl();
        System.out.println(petDAO.getPetById(1));

        Pet petToAdd = new Pet("Bobby", 2, "Dog", 1);
        System.out.println(petDAO.addPet(petToAdd));
    }

}

package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Pet;

public interface PetDAO {
    
    // define CRUD operations

    // create 
    public abstract Pet addPet(Pet pet);

    // read
    // get a pet by its id
    public abstract Pet getPetById(int id);

    public abstract ArrayList<Pet> getAllPets();
    
    // update

    // delete
}

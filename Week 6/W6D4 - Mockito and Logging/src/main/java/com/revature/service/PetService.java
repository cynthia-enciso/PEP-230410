package com.revature.service;

import java.util.ArrayList;

import com.revature.model.Pet;

public interface PetService {
    
    // define CRUD operations

    // create 
    public abstract Pet addPet(Pet pet);

    // read
    // get a pet by its id
    public abstract Pet getPetById(int id);

    public ArrayList<Pet> getAllPetsByVetId(int id);
    
    // update

    // delete
}

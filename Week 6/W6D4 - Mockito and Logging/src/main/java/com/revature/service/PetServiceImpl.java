package com.revature.service;

import java.util.ArrayList;

import com.revature.dao.PetDAO;
import com.revature.dao.PetDAOImpl;
import com.revature.model.Pet;

public class PetServiceImpl implements PetService {

    // state
    private PetDAO petDAO;

    public PetServiceImpl() {
        this.petDAO = new PetDAOImpl();
    }

    @Override
    public Pet addPet(Pet pet) {
        return petDAO.addPet(pet);
    }

    @Override
    public Pet getPetById(int id) {
        return petDAO.getPetById(id);
    }

    @Override
    public  ArrayList<Pet> getAllPetsByVetId(int id) {
        ArrayList<Pet> allPetsReturned = petDAO.getAllPets();
		ArrayList<Pet> allPetsById = new ArrayList<>();
		
		for (Pet pet : allPetsReturned) {
            if (pet.getVetId() == id) {
                allPetsById.add(pet);
            }
        }
	
		return allPetsById;
    }
    
}

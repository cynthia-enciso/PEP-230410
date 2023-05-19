package com.revature.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Pet;
import com.revature.service.PetService;
import com.revature.service.PetServiceImpl;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class PetController {
    
    // state
    private PetService petService;
    static final Logger logger = LoggerFactory.getLogger(PetController.class);


    public PetController() {
        this.petService = new PetServiceImpl();
    }

    public void setupAPI() {
        // create javalin object
        Javalin app = Javalin.create().start(8080);
        
        // create endpoints
        app.get("/pets/vet", this::getPetsByVetIdHandler); 
        app.get("/pets/{id}", this::getPetByIdHandler);
        app.post("/pets", this::addPetHandler);
    }

    // create handlers
    private void getPetsByVetIdHandler(Context ctx) {

        // get request information if needed
        int id = Integer.parseInt(ctx.queryParam("vetid"));

        // call service method
        ArrayList<Pet> petsReturned = petService.getAllPetsByVetId(id);

        // send results to client
        ctx.json(petsReturned);
    }

    private void getPetByIdHandler(Context ctx) {
        
        // log message
        logger.info("Called getPetsByIdHandler!");
        
        // get id
        int id = Integer.parseInt(ctx.pathParam("id"));

        // get Pet back
        Pet petReturned = petService.getPetById(id);

        // return pet to client
        if (petReturned != null) {
            ctx.json(petReturned);
        } else {
            ctx.status(400);
        }
    }

    private void addPetHandler(Context ctx) {
        // get request information if needed
        Pet pet = ctx.bodyAsClass(Pet.class);

        // call service method
        Pet petAdded = petService.addPet(pet);

        // send results to client
        if (petAdded != null) {
            ctx.json(petAdded);
        } else {
            ctx.status(400);
        }
    }
}

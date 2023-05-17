package com.revature;

import java.util.ArrayList;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Controller {
    
    public void setupAPI() {
        // 1. create Javalin object to start using the framework
        Javalin app = Javalin.create().start(8080);

        // 2. test by creating an endpoint for client
            // you'll need a VERB + PATH + HANDLER
        app.get("/", ctx -> {
            ctx.result("Welcome!");
        });

        // CRUD ENDPOINTS
        app.get("/fooditems", ctx -> {
            // get all items
            ArrayList<FoodItem> allItems = App.db.getAllFoodItems();

            // send all items
            ctx.json(allItems);
        });

        app.get("/fooditems/{id}", this::getFoodItemById);
        app.post("/fooditems", this::addFoodItem);
        app.put("/fooditems/{id}", this::updateFoodItem);
        app.delete("/fooditems/{id}", this::deleteFoodItemById);
    }

    // create handlers
    private void getFoodItemById(Context ctx) {
        // get id
        String idText = ctx.pathParam("id");
        int id = Integer.parseInt(idText);
        FoodItem itemToReturn = App.db.getFoodItemById(id);

        if (itemToReturn != null) {
            ctx.json(itemToReturn);
        } else {
            ctx.status(400);
        }
        
    }

    private void addFoodItem(Context ctx) {
        FoodItem foodToAdd = ctx.bodyAsClass(FoodItem.class);
        App.db.addFoodItem(foodToAdd);
    }

    private void updateFoodItem(Context ctx){
        FoodItem updatedItem = ctx.bodyAsClass(FoodItem.class);
        App.db.updateFoodItem(updatedItem);
    }

    private void deleteFoodItemById(Context ctx) {
        String idText = ctx.pathParam("id");
        int id = Integer.parseInt(idText);
        App.db.deleteFoodItemById(id);
    }
}

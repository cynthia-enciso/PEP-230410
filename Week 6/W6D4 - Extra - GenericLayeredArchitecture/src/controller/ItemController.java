package controller;

import model.Item;
import service.ItemService;

// Controller role: defines interface with client
    // define endpoints for getting information from client
    // defines handlers for deciding what to do depending on client's request

public class ItemController {
    
    // depends on the Service
        // Handlers process information and send info to service layer
    private ItemService itemService = new ItemService();

    public void setUpEndpoints() {
        // use some sort of web framework and create relevant object

        // create our endpoints
            // web framework methods that specify an endpoint to listen to
            // and specify what handler responds
    }

    // create handlers
    public void addItemHandler() {
        // get information from request
        Item item = new Item();
        
        // send that information to the respective service method
        boolean result = itemService.addItem(item);

        // send results to client
    }
}

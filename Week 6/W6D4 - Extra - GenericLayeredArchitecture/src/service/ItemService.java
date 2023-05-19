package service;

import java.util.ArrayList;

import dao.ItemDAO;
import model.Item;

// Service role: perform any business logic before manipulating database 
    // (before calling DAO methods)
public class ItemService {
    
    // depends on the DAO 
    private ItemDAO itemDAO = new ItemDAO();
    
    // any logic needed for adding an item
    public boolean addItem(Item item) {
        return itemDAO.addItem(item);
    }

    // any logic needed for getting all items
    public ArrayList<Item> getAllItems() {
        return null;
    }

    // any logic needed for updating an item
    public boolean updateItem(Item item) {
        return itemDAO.updateItem(item);
    }

    // any logic needed for deleting an item
    public boolean deleteItem(Item item) {
        return itemDAO.deleteItem(item);
    }
}

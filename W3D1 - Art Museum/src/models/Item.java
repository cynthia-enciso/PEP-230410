package models;

import java.util.Objects;

// 1. create this class and then explain encapsulation, move on to purchasable item
public class Item {

    // variables
    private String name;
    private String description;
    private String action;

    // constructors
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, String action) {
        this.name = name;
        this.description = description;
        this.action = action;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAction() {
        return action;
    }

    // methods
    public void lookAt() {
        System.out.println("You look at the item: " + this.name);
        System.out.println(this.description);
    }

    // should also get abstracted away to an interface
    public void use() {
        System.out.println("You use the item: " + this.name);
        System.out.println(this.action);
    }

    // after introducing UsableItem, override toString
    public String toString() {
        return "Item: " + this.name +
            " Description: " + this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(action, item.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, action);
    }
    
}
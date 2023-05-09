package models;

import java.util.Objects;

public abstract class Item {

    // variables
    private String name;
    private String description;

    // constructors
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // methods
    public void lookAt() {
        System.out.println("You look at the item: " + this.name);
        System.out.println(this.description);
    }

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
        return Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override 
    public int hashCode() {
        return Objects.hash(name, description);
    }

}
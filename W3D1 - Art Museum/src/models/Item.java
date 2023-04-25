package models;
import java.util.Objects;

public class Item {
    
    // state
    private String name;
    private String description;
    private String action;

    // constructors
    // public Item() {}

    public Item(String name, String description) {
        this.setName(name);
        this.description = description;
    }

    public Item(String name, String description, String action) {
        this.setName(name);
        this.description = description;
        this.action = action;
    }

    // getters and setters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAction() {
        return action;
    }

    public void setName(String name) {
        if (name.equals(" ")) {
            this.name = "GenericItem";
        } else {
            this.name = name;
        }
    }

    // behavior
    public void lookAt() {
        System.out.println("You look at the item: " + this.name);
        System.out.println(this.description);
    }

    public void use() {
        System.out.println("You use the item: " + this.name);
        System.out.println(this.action);
    }

    @Override
    public String toString() {
        return "Item: " + this.name +
            " Description: " + this.description;
    }

    @Override // objects of same type with same characteristics should be equivalent
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

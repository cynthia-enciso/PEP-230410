
package models;

import interfaces.Purchasable;

public class Sketchbook extends Item implements Purchasable {
    
    public Sketchbook(String name, String description) {
        super(name, description);
    }

    public void use() {
        System.out.println("You use the item: " + this.getName());
        System.out.println("You sketch what you see and then admire your work. Not bad.");
    }

    public void purchase() {
        System.out.println("You use the item: " + this.getName() + " for $5.50");
    }

}

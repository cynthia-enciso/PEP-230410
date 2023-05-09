package models;

public class Painting extends Item {

    public Painting(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        System.out.println("You cannot use this item");
    }
}

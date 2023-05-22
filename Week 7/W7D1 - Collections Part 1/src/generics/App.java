package generics;

import generics.containers.*;
import generics.food.*;
import generics.tools.*;

public class App {
    public static void main(String[] args) {
        Container<Item> myContainer1 = new Container<>();
        myContainer1.setItem(new Pencil());
        myContainer1.setItem(new Sandwich());

        // Container<String> myContainer2 = new Container<>();

        // notice that tupperware cannot contain any type of item
        Tupperware<Food> tupperware = new Tupperware<>();
        tupperware.setItem(new Food());
        tupperware.setItem(new Chips());
        // tupperware.setItem(new Pencil()); // can't use Tools

        Container<Food> fridge = new Container<>();
        tupperware.setItem(new Food());
        tupperware.setItem(new Chips());
    }
}

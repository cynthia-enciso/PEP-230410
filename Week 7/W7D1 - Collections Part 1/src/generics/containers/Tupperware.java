package generics.containers;

import generics.food.Food;

// creating a class that restricts the type that can be passed in
public class Tupperware<T extends Food> extends Container<T> {
    
}

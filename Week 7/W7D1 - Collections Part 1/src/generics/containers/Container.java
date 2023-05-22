package generics.containers;

import java.util.ArrayList;

import generics.Item;

// creating a generic class that takes in a placeholder type
public class Container<T> {
    
    // state
    private T item;

    // setter
    public void setItem(T item) {
        this.item = item;
    }

    // getter
    public T getItem() {
        return item;
    }
}

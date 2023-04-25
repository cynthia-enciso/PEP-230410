package models;

import java.util.Objects;

public class PurchasableItem extends Item {

    // state
    private String price;

    // constructors
    public PurchasableItem(String name, String description, String price, String action) {
        super(name, description, action);
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PurchasableItem)) {
            return false;
        }
        PurchasableItem purchasableItem = (PurchasableItem) o;
        return Objects.equals(price, purchasableItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }
    
}

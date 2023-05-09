package interfaces;

// I didn't really need price state for my program, so this works
// if I DID want to use a price, I could make two separate inheritance hierarchies: item and artwork
public interface Purchasable {
    
    public abstract void purchase();
}

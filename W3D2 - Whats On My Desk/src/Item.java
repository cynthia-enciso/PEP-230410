public abstract class Item {
    
    private String color;


    public abstract void performAction();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

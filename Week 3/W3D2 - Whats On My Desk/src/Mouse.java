public class Mouse extends Item implements Pluggable {
    
    private int buttonCount;


    public int getButtonCount() {
        return this.buttonCount;
    }

    public void setButtonCount(int buttonCount) {
        this.buttonCount = buttonCount;
    }

    @Override
    public void performAction() {
        System.out.println("mouse clicks!");
    }

    @Override
    public void plugsIntoUSB() {
        System.out.println("Mouse plugged in!");

    }
}

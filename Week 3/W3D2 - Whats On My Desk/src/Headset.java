public class Headset extends Item implements Pluggable {
    
    @Override
    public void performAction() {
        System.out.println("record audio!");
    }

    @Override
    public void plugsIntoUSB() {
        System.out.println("Headset plugged in!");
    }
}

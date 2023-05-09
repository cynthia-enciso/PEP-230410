public class Notepad extends Item {
    

    public void open() {
        System.out.println("notepad is opened");
    }

    @Override
    public void performAction() {
        System.out.println("take notes");
    }
}

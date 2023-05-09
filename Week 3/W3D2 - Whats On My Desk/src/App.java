import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        Mouse myMouse = new Mouse();
        Notepad myNotepad = new Notepad();
        Headset myHeadset = new Headset();

        items.add(myMouse);
        items.add(myNotepad);
        items.add(myHeadset);

        

        // example of upcasting objects
        // myMouse.setColor("black");
        Item myFavoriteItem = myMouse;
        myFavoriteItem.performAction();
        // System.out.println(myFavoriteItem.getColor());

        // example of downcasting objects
        // 1. can we have a subtype reference variable assigned a supertype object
        // Item item = new Item();
        // Headset myOtherHeadset = (Headset) item;

        // 2. downcasting
        for (Item item : items) {
            if (item instanceof Notepad) {
                // downcasting - changing type of reference variable
                Notepad myOtherNotepad = (Notepad)item;
                myOtherNotepad.open();
                myOtherNotepad.getColor();
            }
        }
    }
}

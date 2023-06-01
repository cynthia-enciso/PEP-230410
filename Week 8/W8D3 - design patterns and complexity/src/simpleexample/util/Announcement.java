package simpleexample.util;


// singleton

public class Announcement {
    
    // we want this and the getAnnoucement method to be static 
    // to avoid using object creation (which we cannot do) outside of this class
    private static Announcement announcement;

    // we want to have the constructor be private
    private Announcement() {}

    // static method needs to refer to static reference variable
    public static Announcement getAnnouncement() {
        // for first time call, initialize announcement
        if (announcement == null) {
            announcement = new Announcement();
        }

        return announcement;
    }

    // behavior
    public void printMessage(String message) {
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_PURPLE + message + ANSI_RESET);
    }
}

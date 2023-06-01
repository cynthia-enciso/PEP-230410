package simpleexample;

import simpleexample.districts.District;
import simpleexample.util.Announcement;

public class App {
    public static void main(String[] args) {
        Announcement.getAnnouncement().printMessage("Welcome to the theme park!");
        District district = new District();
        district.setUp("kid");
        
    }
}

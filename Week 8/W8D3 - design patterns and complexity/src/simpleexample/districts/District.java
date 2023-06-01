package simpleexample.districts;

import simpleexample.SimpleAttractionFactory;
import simpleexample.attractions.Attraction;
import simpleexample.util.Announcement;

// this class depends on the Factory to get an object
public class District {
    
    // code that wants to create some type of attraction
    public void setUp(String type) {
        // I'm going to need to create an attraction
        // use factory to get object we want
        Attraction attraction = SimpleAttractionFactory.createAttraction(type);

        // I want to perform set up operations
        attraction.turnOn();
        attraction.test();
        attraction.allowEntry();

        // This is using the Singleton
        Announcement.getAnnouncement().printMessage(attraction.getName() + " is ready for everyone!");
    }
}

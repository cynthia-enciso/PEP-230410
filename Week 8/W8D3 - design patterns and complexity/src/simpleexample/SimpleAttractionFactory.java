package simpleexample;

import simpleexample.attractions.*;

public class SimpleAttractionFactory {
    
    public static Attraction createAttraction(String type) {

        // decide what type of attraction to create
        if (type.equals("water")) {
            return new WaterSlideExtreme();
        } else if (type.equals("general")) {
            return new LoopyCoaster();
        } else if (type.equals("kid")) {
            return new TeacupSpin();
        }

        return null;
    }
}

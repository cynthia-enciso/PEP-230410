package actual.districts;

import actual.attractions.Attraction;

public abstract class District {

    // client code
    public void setUp() {
        // get attraction created somehow
        Attraction attraction;
        attraction = createAttractionFactory();

        // do set up process
        attraction.turnOn();
        attraction.test();
        attraction.allowEntry();
    }

    // factory method: gets rid of a single Factory class.
        // we can create however many subclasses that represent Factories. 
        // want to have a new type of attraction? Extend this class!
    public abstract Attraction createAttractionFactory();
}

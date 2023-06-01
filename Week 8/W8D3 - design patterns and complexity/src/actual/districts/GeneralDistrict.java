package actual.districts;

import actual.attractions.Attraction;
import actual.attractions.LoopyCoaster;

public class GeneralDistrict extends District {

    @Override
    public Attraction createAttractionFactory() {
        return new LoopyCoaster();
    }
    
}

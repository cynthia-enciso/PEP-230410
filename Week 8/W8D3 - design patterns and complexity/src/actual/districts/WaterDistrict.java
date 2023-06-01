package actual.districts;

import actual.attractions.Attraction;
import actual.attractions.WaterSlideExtreme;

public class WaterDistrict extends District {
    @Override
    public Attraction createAttractionFactory() {
        return new WaterSlideExtreme();
    }
    
}

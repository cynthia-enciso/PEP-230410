package actual.districts;

import actual.attractions.Attraction;
import actual.attractions.TeacupSpin;

public class KidDistrict extends District{
    
    @Override
    public Attraction createAttractionFactory() {
        return new TeacupSpin();
    }
}

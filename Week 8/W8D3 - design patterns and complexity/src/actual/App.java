package actual;

import actual.districts.District;
import actual.districts.KidDistrict;
import actual.districts.WaterDistrict;

public class App {
    public static void main(String[] args)  {
        District newDistrict = new WaterDistrict();
        newDistrict.setUp();

        newDistrict = new KidDistrict();
        newDistrict.setUp();
    }
}

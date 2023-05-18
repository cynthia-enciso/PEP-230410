// in this example, we see that we can use a supertype reference variable, Pluggable
// to specify where we can use its subtypes
interface Pluggable {
    public abstract void canPlugIntoComputer();
}

class Microphone implements Pluggable {
    public void canPlugIntoComputer() {
        System.out.println("Microphone is plugged in!");
    }
}

class Headphones implements Pluggable {
    public void canPlugIntoComputer() {
        System.out.println("Headphones are plugged in!");
    }
}

public class A_PolymorphicCasting {

    public static void useDevice(Pluggable device) {
        System.out.println("We found a device:");
        device.canPlugIntoComputer();
    }

    // we can use the subtypes as values that can be assigned to variables
    // OR passed into methods as input
    public static void main(String[] args) {
        // assign subtype as value to a variable
        Pluggable device = new Headphones(); // can also assign a Microphone object

        // pass subtype to a method
        useDevice(new Microphone()); // can also pass in headphones!

    }
    // using functional interfaces, we can use functions as values that can be
    // assigned to variables or passed into methods as input, too! 
}

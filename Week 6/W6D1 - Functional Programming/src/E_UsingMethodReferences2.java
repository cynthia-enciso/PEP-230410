
/**
 *  using a method reference to reference a constructor:
 *  useful for concise way of creating objects (usually using a stream, which we will talk about later)
 * 
 * In this class:
 * - a class with the main method for trying out code
 * - a Dog class that defines a dog with two constructors
 * - a functional interface that defines a method that takes in no params and returns a Dog
 * - a functional interface that defines a method that takes in a param and returns a Dog with
 *      its name state initialized
 */
public class E_UsingMethodReferences2 {
    public static void main(String[] args) {
    // I like this reference: https://www.nextptr.com/tutorial/ta1314009273/uses-of-constructor-method-reference
    UnnamedDogGenerator dogGenerator1 = Dog::new; // you can now generate unnamed dogs
    System.out.println(dogGenerator1.get().name);
    NamedDogGenerator dogGenerator2 = Dog::new; // you can now generate named dogs
    System.out.println(dogGenerator2.get("Benny").name);
    System.out.println(dogGenerator2.get("Darla").name);
    Dog someDog = dogGenerator2.get("Carlos");
    System.out.println(someDog.name);
    }
}

class Dog {

    String name;

    public Dog() {}

    public Dog(String name) {
        this.name = name;
    }
}

// give me a dog somehow
interface UnnamedDogGenerator {
    Dog get();
}

interface NamedDogGenerator {
    Dog get(String name);
}

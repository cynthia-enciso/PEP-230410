/**
    Definition: special lambdas that make use of existing methods to be even more concise

    - in this file: a functional interface that represents a TYPE of function we want to work with
    - a class with the main method for trying out code
    - a class called Calculator with a static method and instance method
 */

 // create a type
interface BinaryCalculator {
    public double binaryOperation(double value1, double value2);
} 


public class E_UsingMethodReferences1 {

    // create method that takes in this type
    public static void printBinaryResult(double value1, double value2, BinaryCalculator calculator) {
        System.out.println(calculator.binaryOperation(value1, value2));
    }

    public static void main(String[] args) {
        // static method reference
        printBinaryResult(1, 3, Calculator::average);

        // instance method reference
        
        Calculator calc = new Calculator();
        printBinaryResult(3, 9, calc::getMax);
    }
    
}

class Calculator {
    // calculate an average of the two
    public static double average(double value1, double value2) {
        return (value1 + value2) / 2;
    }

     // calculate an average of the two
    public double getMax(double value1, double value2) {
        if (value1 > value2) {
            return value1;
        } else {
            return value2;
        }
    }
}

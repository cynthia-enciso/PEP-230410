// THIS IS THE MOST IMPORTANT PART OF THIS: FUNCTIONS AS PARAMETERS
interface BinaryCalculator {
    public double binaryOperation(double value1, double value2);
} 

public class C_UsingLambdasAsParams {

    // higher-order function: function that takes in another function
        // param specifies the TYPE of function that can be passed in
    public static void printBinaryResult(double value1, double value2, BinaryCalculator calculator) {
        System.out.println(calculator.binaryOperation(value1, value2));
    }

    public static void main(String[] args) {
        // when calling the higher oder function, you can directly pass in an implementation
            // as long as it meets the requirements of the TYPE of function
        printBinaryResult(1, 2, (a, b) -> (a + b) / 2);
    }
}

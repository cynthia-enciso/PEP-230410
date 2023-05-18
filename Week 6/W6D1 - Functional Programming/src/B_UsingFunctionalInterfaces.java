// Functional Interfaces: specify a type of action / function
    // wherever we use these types, we can use a single-use function

    // Functional interfaces provide target types for lambda expressions and method references
interface BinaryCalculator {
    public double binaryOperation(double value1, double value2);
}

class AverageTwoValues implements BinaryCalculator {
    @Override
    public double binaryOperation(double value1, double value2) {
        return (value1 + value2) / 2;
    }
    
}

public class B_UsingFunctionalInterfaces {
    public static void main(String[] args) {
        // GOAL: I want to be able to write a function not tied to a class

        // OOP way
        BinaryCalculator myCalc = new AverageTwoValues();
        double result = myCalc.binaryOperation(1, 3);
        System.out.println(result);

        // functional programming
        BinaryCalculator myCalc2 = (a, b) -> {
            if (a > b) {
                return a;
            } else {
                return b;
            }
        };

        double result2 = myCalc2.binaryOperation(2, 4);
        System.out.println(result2);
    }
}

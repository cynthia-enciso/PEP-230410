// lambda: a short-lived, in-line implementation of a functional interface

interface ReturnValue {
    public String returnValue(String value);
}

interface PrintTwoValues {
    public void printValues(String value1, int value2);
}

public class B_UsingLambdas {
    public static void main(String[] args) {
        // long-form
        PrintTwoValues lambda1 = (String value1, int value2) -> {
            System.out.println(value1);
            System.out.println(value2);
        };

        // omit datatypes
        PrintTwoValues lambda2 = (value1, value2) -> {
            System.out.println(value1);
            System.out.println(value2);
        };

        // if there is ONE param, you can omit the parenthesis 
        // (as long as you also omit the datatype)
        ReturnValue lambda3 = value -> {
            return value;
        };

        // if the code block contains only one statement, you don't need curly braces
        PrintTwoValues lambda4 = (value1, value2) -> System.out.println(value1 + "\n" + value2);

        // if the single statement returns a value, 
        // you omit the return keyword if you omit the curly braces
        ReturnValue lambda5 = value -> value;
    
    }
}

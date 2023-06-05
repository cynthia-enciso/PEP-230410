package optional;

import java.util.Optional;

/*
"The purpose of Optional is not to replace every single null reference in your codebase 
but rather to help design better APIs in which—just by reading the signature of a method—users can tell
whether to expect an optional value. 

In addition, Optional forces you to actively unwrap an Optional to deal with the absence of a value;
as a result, you protect your code against unintended null pointer exceptions."
from: https://www.oracle.com/technical-resources/articles/java/java8-optional.html

- they are primarily intended to be used as a return type
- but they can also be used where null is likely to cause errors
from: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
 */

public class UsingOptionals {
    public static void main(String[] args) {
        // =================== of, ifPresent, isPresent, get ========================
        // syntax of using Optionals makes it very clear that there may or may not be a value
        Optional<String> returnedOptional = returningAnOptional();

        // ideally, try and perform an action IF a value is within the Optional
        returnedOptional.ifPresent(x -> System.out.println(x));

        // if you want to return and save the value somewhere, use isPresent
        String unwrappedValue = "";

        if (returnedOptional.isPresent()) {
            unwrappedValue = returnedOptional.get();
        }
        
        System.out.println(unwrappedValue);

        // ==================== ofNullable, empty, orElse =======================

        String myReassignedString = "tomatoes";

        // complex logic
        boolean complexCodeResultsinNull = true;
        if (complexCodeResultsinNull) {
            myReassignedString = null; 
        }

        Optional<Character> characterWrapped = takingInAndReturningOptional(Optional.ofNullable(myReassignedString));

        char characterUnwrapped = characterWrapped.orElse('-');

        System.out.println(characterUnwrapped);
    }

    public static Optional<String> returningAnOptional() {
        return Optional.of("hello world");
    }

    // you typically wouldn't be using an optional as a parameter
    // more discussion about it here: https://stackoverflow.com/questions/31922866/why-should-java-8s-optional-not-be-used-in-arguments
    public static Optional<Character> takingInAndReturningOptional(Optional<String> myString) {
        Optional<Character> charToReturn = Optional.empty();

        charToReturn = myString.map(x -> x.charAt(1));

        return charToReturn;
    }
}

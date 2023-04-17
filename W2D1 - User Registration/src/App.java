import java.util.Scanner;
import java.util.regex.Pattern;

import com.revature.util.ValidationUtil;

public class App {
    public static void main(String[] args) {
        // scanner object
        Scanner scanner = new Scanner(System.in);
        // welcome user
        System.out.println("============ WELCOME TO NILE =========");
        System.out.println("============ REGISTER BELOW  =========");
        System.out.println("======================================");

        boolean usernameIsInvalid = true;
        boolean passwordIsInvalid = true;

        // loop
        while (usernameIsInvalid || passwordIsInvalid) {
            // take in the username
            System.out.println("Username requirements:");
            System.out.println("1. Must be at least 3 characters in length");
            System.out.println("2. Must not exceed 25 characters in length");
            System.out.println("3. Must not include special characters such as: " + ValidationUtil.SPECIAL_CHARACTERS);
            System.out.println("4. Must not contain spaces");
            System.out.println("Enter a username: ");
            String username = scanner.nextLine();

            // validate username
                //if it doesn't contain spaces
                // doesn't contain special characters
                // if it is within the range 
            if (!username.contains(" ") && 
            !ValidationUtil.hasSpecialCharacters(username) &&
            ValidationUtil.lengthIsValid(3, 25, username)
            ) {
                usernameIsInvalid = false; // username IS valid
            } else {
                System.out.println("Username is invalid. Try again.");
                usernameIsInvalid = true;
                continue;
            }

            // take in the password
            System.out.println("Password requirements:");
            System.out.println("1. Must be at least 12 characters in length");
            System.out.println("2. Must not exceed 25 characters in length");
            System.out.println("3. Must include a special character such as: " + ValidationUtil.SPECIAL_CHARACTERS);
            System.out.println("4. Must not contain spaces");
            System.out.println("Enter a password: ");
            String password = scanner.nextLine();

            // validate password
                //if it doesn't contain spaces
                // doesn't contain special characters
                // if it is within the range 
                if (!password.contains(" ") && 
                ValidationUtil.hasSpecialCharacters(password) &&
                ValidationUtil.lengthIsValid(12, 25, password)
                ) {
                    passwordIsInvalid = false; // username IS valid
                } else {
                    System.out.println("Password is invalid. Try again.");
                    passwordIsInvalid = true;
                }
            
        }
            

        // redirecting.... just kidding this is the end of the program.
        System.out.println("Registration success. Redirecting...");
        System.out.println("Just kidding, this is the end of the program.");
        scanner.close();
    }
}

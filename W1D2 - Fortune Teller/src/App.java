import java.util.Scanner;

import javax.swing.text.StyledEditorKit.AlignmentAction;

public class App {
    public static void main(String[] args)  {
        // create a Scanner object
        Scanner scanner = new Scanner(System.in);

        // greet the user
        System.out.println("===================================\n");
        System.out.println("Welcome to the Fortune Teller Game!\n");
        System.out.println("===================================\n");

        // start asking questions
        System.out.println("Give me a word longer than 5 characters.");
        String word = scanner.nextLine();

        System.out.println("What is your age?");
        int age = scanner.nextInt();

        System.out.println("What is your favorite color?");
        String color = scanner.next();

        // provide user with output
        System.out.println("\n===================================");
        System.out.println("Your lucky number is: " + getLuckyNumber(age));
        System.out.println("Your lucky password is: " + getLuckyPassword(word, color));
        System.out.println("\n===================================");

        // close the scanner object
    }

    // create methods that perform calculations
    public static double getLuckyNumber(int age) {

        // basic operations
        age = age + 20;

        age = age - 3;

        // age = age % 3;
        age %= 3;

        age *= 5;

        age++;

        return age;
    }


    public static String getLuckyPassword(String word, String color) {

        // create variables
        char firstLetter;
        char lastLetter;
        String subString;
        String luckyPassword = "";

        // bobby = 5 characters
        // 01234
        firstLetter = word.charAt(0);
        lastLetter = word.charAt(word.length() - 1);
        subString = word.substring(1, 3);
        luckyPassword = subString + "#" + firstLetter + 3 + color + lastLetter + word.length(); 

        return luckyPassword;
    }
}

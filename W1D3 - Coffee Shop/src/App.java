import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // create scanner object
        Scanner scanner = new Scanner(System.in);

        // greet user
        System.out.println("===================================");
        System.out.println("Welcome to Robust Roasts!");
        System.out.println("===================================");

        // create counter
        int counter = 0;

        // program loop
        loop:
        do {
            // display a menu
            System.out.println("Please make a selection:");
            System.out.println("1) Americano");
            System.out.println("2) Latte");
            System.out.println("3) Cappuccino");
            System.out.println("4) Quit");

            // get user input
            int decision = scanner.nextInt();

            // decision structure(s)?

            // if user has already ordered a coffee
            if (counter > 0) {
                System.out.println("Another one?! Okay then.");
            }

            switch(decision){
                case 1: System.out.println("Here's your Americano");
                    break;
                case 2: System.out.println("Here's your Latte");
                    break;
                case 3: System.out.println("Here's your Cappuccino");
                    break;
                case 4: System.out.println("Thank you for shopping at Robust Roasts!");
                    break loop;
                default: System.out.println("Invalid choice.");
            }

            if (decision < 4 && decision > 0) {
                counter++;
            }

            
        } while(true);
            
        // say goodbye
        System.out.println("Enjoy your cup of joe!");

        // close scanner
        scanner.close();
    }
}

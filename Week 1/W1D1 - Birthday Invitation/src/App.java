import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        // create scanner object to work with input
        Scanner scanner = new Scanner(System.in);

        // prompt user
        System.out.println("Enter a person:");
        // getting user input
        String person = scanner.nextLine();
        System.out.println("Enter a number: ");
        String number = scanner.nextLine();
        System.out.println("Enter a pural noun: ");
        String items = scanner.nextLine();
        System.out.println("Enter a plural profession: ");
        String professions = scanner.nextLine();
        System.out.println("Enter an event: ");
        String event = scanner.nextLine();
        System.out.println("Enter an adjective: ");
        String adjective = scanner.nextLine();
        System.out.println("Enter a nickname: ");
        String nickname = scanner.nextLine();

        // do something with input
        System.out.print("\n");
        System.out.println("Dear " + person + ",");
        System.out.println("I want to invite you to my birthday party, " +
                            "since you know I am turning " + number + " years old.");
        System.out.println("There will be fun things like " +
                            items + " and " + professions + " at my party. There will even be a " +
                            event + " event!");
        System.out.println("Please come to my party this year. If not, I will cry "
                            + adjective + ".");
        System.out.println("Sincerely,");
        System.out.println(nickname);

        // close our scanner object
        scanner.close();
    }
}

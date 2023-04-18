import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        // create scanner object
        Scanner scanner = new Scanner(System.in);

        // welcome user
        System.out.println("==============================================");
        System.out.println("You are laying in bed trying to sleep.");
        System.out.println("But you can't.\nYou got hit with those late night munchies.\n");

        // initialize funds
        double funds = 40;

        boolean timeIsPassing = true;
        // loop
        while (timeIsPassing) {
            // check if its payday
            System.out.println("'What day is it?,' you think to yourself.");
            String weekday = returnARandomWeekday();
            if (weekday.equals("Friday")) {
                funds += 20;
                System.out.print("Sweet, it's payday");
            } else {   
                System.out.print("It's " + weekday);
            }
            System.out.printf(" and you have $%5.2f in your bank account.%n%n", funds);

            // deliberate and make purchase
            int combosToPurchase = deliberate(funds, scanner);
            funds = makePurchase(combosToPurchase, funds);

            // show results
            System.out.printf("%nYou check your bank account. You have $%5.2f left.%n%n", funds);

            // offer to continue making purchases or quit
            System.out.println("Days pass by. Continue? Y/N");
            String decision = scanner.next();
            // using == to compare a String from the console against a string literal
            // would return false, even if they had the same character sequence
            // because of how they are stored in memory
            if (!decision.equals("Y")) {
                timeIsPassing = false;
            }
            System.out.println("==============================================");
            
        }
            

    }

    public static String returnARandomWeekday() {
        // create a weekdays array
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // generate a random index
        Random randomizer = new Random();
        int randomIndex = randomizer.nextInt(weekdays.length); // won't include 7 as a possible return value, just 0-6

        // return random weekday
        return weekdays[randomIndex];
    }

    public static int deliberate(double funds, Scanner scanner) {
        // figure out how many combo meals you CAN buy
        System.out.println("A combo meal from your favorite restaurant, Tendies, costs $5.50");
        System.out.println("You can afford " + (int)(funds / 5.5) + " of them.");

        // decide how many you actually WANT TO buy
        System.out.println("But how many combos do you think you'll actually eat?");
        int combos = scanner.nextInt();
        System.out.println("After much deliberation, you chose to purchase " + combos + " combo meals.");
        return combos;
    }

    public static double makePurchase(int combos, double funds) {
        double purchaseAmount = combos * 5.5; // int + double = double

        if (funds >= purchaseAmount) {
            funds -= purchaseAmount;
        } else {
            System.out.println("Dang it, I'm broke! Going to bed hungry tonight.");
        }

        return funds; 
    }

    // call this method in main to see it run
    public static void memoryExample() {
        int x = 10;
        int y = 10;

        System.out.println(x == y);

        String word1 = new String("hello");
        String word2 = new String("hello");

        // comparing our reference variables
            // do the variables contain the same value?
            // reference variables contain MEMORY LOCATIONS
            // which means we're comparing whether or not they reference the
            // same object
        System.out.println(word1 == word2);

        
        // re-assign then compare them again
        // word2 = word1;
        // System.out.println(word1 == word2);
        System.out.println(word1.equals(word2));

        String word3 = "hello";
        String word4 = "hello";
        System.out.println(word3 == word4);
    }

}

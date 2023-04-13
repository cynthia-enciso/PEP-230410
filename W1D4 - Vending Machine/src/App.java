import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        // welcome user
        System.out.println("===================================");
        System.out.println("Grab N' Go Snacks and Such");
        System.out.println("===================================\n");

        // fill in vending machine
        String[] row1 = {"Skittles", "Froot Loops", "Chips"};

        String[] row2 = new String[3];
        row2[0] = "Mountain Dew";
        row2[1] = "Grandma's Cookie";
        row2[2] = "Granola Bar";

        String[] row3 = {"Gogurt", "Goldfish", "M&Ms"};

        // loop
        boolean isRunning = true;

        while(isRunning) {
            // menu
            System.out.println("Please choose a row to look at, or quit:");
            System.out.println("1) Row 1");
            System.out.println("2) Row 2");
            System.out.println("3) Row 3");
            System.out.println("4) Quit");

            // get input
            int rowSelection = scanner.nextInt();
            int itemSelection;

            // make decision
            switch (rowSelection) {
                case 1: // display the items
                        System.out.println("Row 1 Items:");
                        displayItems(row1);

                        // take user input again
                        itemSelection = scanner.nextInt();

                        // do something after taking in user input
                        selectItem(row1, itemSelection);
                        break;
                case 2: // display the items
                        System.out.println("Row 2 Items:");
                        displayItems(row2);

                        // take user input again
                        itemSelection = scanner.nextInt();

                        // do something after taking in user input
                        selectItem(row2, itemSelection);
                        break;
                case 3: // display the items
                        System.out.println("Row 3 Items:");
                        displayItems(row3);

                        // take user input again
                        itemSelection = scanner.nextInt();
                        // do something after taking in user input
                        selectItem(row3, itemSelection);
                        break;
                case 4: // You can use System.exit(0); to end program here
                        isRunning = false; 
                        break;
                default: System.out.println("Invalid selection.");
                        break;
            }
                
        
        }
            
        

        // say goodbye and close scanner
    }

    public static void displayItems(String[] array) {
        for( int i = 0; i < array.length; i++){ 
            System.out.println(i + 1 + ")" + array[i]);
        }

        System.out.println();
    }

    public static void selectItem(String[] array, int selection) {
        System.out.println("You selected: " + array[selection - 1]);
    }
}

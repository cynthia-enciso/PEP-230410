import java.util.ArrayList;
import java.util.Scanner;

import models.*;

public class App {

        // create scanner object
        public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // encapsulationExample();

        // introduce app
        System.out.println("============================");
        System.out.println("    Coolville Art Museum    ");
        System.out.println("============================");
        System.out.println("You enter the museum.");

        // initalize museum
        ArrayList<Painting> artwork = new ArrayList<>();
        artwork.add(new Painting("Fona Meesa", "Painting of a woman's profile. She gives you a smug smile."));
        artwork.add(new Painting("Starless Night", "Painting of a clear night sky. Kind of boring."));
        artwork.add(new Painting("Girl with a Pearl Necklace", "Just a painting of a girl wearing a pearl necklace."));


        // loop
        loop:
        while(true) {
            // display artwork to view
            System.out.println("\nWhich artwork are you interested in?");
            displayPaintings(artwork);

            // get user decison
            int decision = scanner.nextInt();

            switch(decision) {
                case 1: 
                case 2: 
                case 3: artwork.get(decision - 1).lookAt();
                        break;
                case 4: System.out.println("You leave the museum's gallery.");
                        break loop;
                default: System.out.println("Invalid decision.");

            }
        }
            
        // user will enter gift shop
        System.out.println("\nYou enter the gift shop.");
        ArrayList<Sketchbook> sketchbooks = new ArrayList<>();
        Sketchbook firstSketchbook = new Sketchbook("Spiral-Bound Red Sketchbook", "This sketchbook looks like a good deal. 100 pages!", "You sketch what you see and then admire your work. Not bad.", "$5.50");
        Sketchbook secondSketchbook = new Sketchbook("Spiral-Bound Red Sketchbook", "This sketchbook looks like a good deal. 100 pages!", "You sketch what you see and then admire your work. Not bad.", "$5.40");
        sketchbooks.add(firstSketchbook);
        sketchbooks.add(secondSketchbook);


        // user will compare purchasable items
        System.out.println("You compare the sketchbooks."); 
        if(firstSketchbook.equals(secondSketchbook)) {
            System.out.println("They're identical!");
        } else {
            System.out.println("There's a difference between them, but you aren't sure what it is.");
        
        }

        // say goodbye
        System.out.println("You buy the first sketchbook and leave the museum.");

        scanner.close();
    }

    public static void displayPaintings(ArrayList<Painting> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ") " + list.get(i).getName());
        }

        System.out.println(list.size() + 1 + ") quit");
    }
    public static void encapsulationExample() {
        Item item = new Item(" ", "an oil painting of flowers", "");
        System.out.println("name of item: " + item.getName());

        System.out.println(item);
    }
}

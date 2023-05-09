import java.util.ArrayList;
import java.util.Scanner;

import models.Item;
import models.Painting;
import models.Sculpture;
import models.Sketchbook;
import util.ItemUtil;

public class App {
    // DIP: have an arraylist of paintings for gallery
    // then fix tomorrow with arraylist of item
    public static void main(String[] args) {
        // create scanner object
        Scanner scanner = new Scanner(System.in);

        // introduce gallery
        System.out.println("============================");
        System.out.println("    Coolville Art Museum    ");
        System.out.println("============================");
        System.out.println("You enter the museum.");
        // initalize gallery
        ArrayList<Item> artwork = new ArrayList<>();
        artwork.add(new Painting("Fona Meesa", "Painting of a woman's profile. She gives you a smug smile."));
        artwork.add(new Sculpture("The Frisbee Thrower", "Ancient Greek scultpure of a man throwing a discus... no wait its a frisbee."));
        artwork.add(new Painting("Girl with a Pearl Necklace", "Just a painting of a girl wearing a pearl necklace."));


        // gallery loop
        loop:
        while(true) {
            // user can choose to look at items or quit
            System.out.println("\nWhich artwork are you interested in?");
            ItemUtil.displayItems(artwork);

            // get user's decision
            int decision = scanner.nextInt();

            switch(decision) {
                case 1: 
                case 2: 
                case 3: artwork.get(decision - 1).lookAt(); // as look as it's an item, you can look at it!
                        break;
                case 4: System.out.println("You leave the gallery.");
                        break loop;
                default: System.out.println("Invalid decision.");

            }
        }
            
        System.out.println("\nYou enter the gift shop.");

        // initialize gift shop with two equivalent items
        ArrayList<Sketchbook> sketchbooks = new ArrayList<>();
        sketchbooks.add(new Sketchbook("Spiral-Bound Red Sketchbook", "This sketchbook looks like a good deal. 100 pages!"));
        sketchbooks.add(new Sketchbook("Spiral-Bound Red Sketchbook", "This sketchbook looks like a good deal. 100 pages!"));

        // compare sketchbooks
        System.out.println("You compare the sketchbooks.");
        Sketchbook firstSketchbook = sketchbooks.get(0);
        Sketchbook secondSketchbook = sketchbooks.get(1);
        if (firstSketchbook.equals(secondSketchbook)) {
            System.out.println("They're identical!");
        } else {
            System.out.println("There's a difference between them, but you aren't sure what it is.");
        }

        
        // goodbye user!
        System.out.println("You buy the first sketchbook and leave the museum.");

        scanner.close();
    }

}

package setexample;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// different useful sets:
// hashset = insertion order not guaranteed
// linkedhashset = for if you do want insertion order guaranteed
// treeset = for if you want the elements to be sorted
public class MexicanLottery {
    // mexican lottery is where there are boards of images and a deck of matching cards.
    // the cards are shuffled and the images are called out
    // whoever's board images have all matched the winning cards first is the winner!
    public static void main(String[] args) {
        // creat set of winning cards
        Set<String> winningCards = new HashSet<>();

        // initialize set
        Collections.addAll(winningCards, "The Rooster", 
                                                    "The Tree", 
                                                    "The Drunkard",
                                                    "The World", 
                                                    "The Shrimp",
                                                    "The Sun", 
                                                    "The Flowerpot",
                                                    "The Frog",
                                                    "The Hand",
                                                    "The Boot",
                                                    "The Palm Tree",
                                                    "The Fish",
                                                    "The Little Devil",
                                                    "The Lady",
                                                    "The Barrel",
                                                    "The Umbrella");

        // create boards
        HashSet<String> board1 = new HashSet<>();
        Collections.addAll(board1,"The Tree", "The Drunkard", "The World", "The Fish");
        HashSet<String> board2 = new HashSet<>();
        Collections.addAll(board2,"The Boot", "The Little Devil", "The Lady", "The Sun");
        HashSet<String> board3 = new HashSet<>();
        Collections.addAll(board3,"The Lady", "The World", "The Palm Tree", "The Fish");
        System.out.println("Board One:\n" + board1);
        System.out.println("Board Two:\n" + board2); 
        System.out.println("Board Three:\n" + board3);

        // set operations
        // unique = adds all elements together (but no duplicates)
        HashSet<String> union = new HashSet<String>(board1);
        union.addAll(board2);
        System.out.println("Union of first two boards:\n" + union); 

        // intersection = all common values between the two
        HashSet<String> intersection = new HashSet<String>(board2);
        intersection.retainAll(board3);
        System.out.println("Intersection of last two boards:\n" + intersection);

         // Difference between sets = unique values from first set
        HashSet<String> difference = new HashSet<String>(board1);
        difference.removeAll(board3);
        System.out.println("Difference between board 1 and 3:\n" + difference);
 
        // now let's play the game!
        Iterator<String> iterator = winningCards.iterator();

        while (iterator.hasNext()) {
            // get next card
            String nextCard = iterator.next();
            
            // call out winning card
            System.out.println(nextCard + "!");

            // check for matches
            if (board1.contains(nextCard)) {
                board1.remove(nextCard);
            }

            if (board2.contains(nextCard)) {
                board2.remove(nextCard);
            }

            if (board3.contains(nextCard)) {
                board3.remove(nextCard);
            }

            // check for winner
            boolean winner = false;

            if (board1.isEmpty()) {
                System.out.println("Player with board 1 won!");
                winner = true;
            }

            if (board2.isEmpty()) {
                System.out.println("Player with board 2 won!");
                winner = true;
            }

            if (board3.isEmpty()) {
                System.out.println("Player with board 3 won!");
                winner = true;
            }

            if (winner) {
                return;
            }
        }
    }
}

import models.*;
import java.util.Scanner;


class Main {
  public static void main(String[] args) {
    // initialize 2 players
    Player player = new Player("Robocop", "Warrior");
    Monster monster = new Monster("Frankenstein", "Zombie");
    Scanner scanner = new Scanner(System.in);
    
    // loop
    while (player.health > 0 && monster.health > 0) {
      String playerChoice;
      System.out.println("Player health: " + player.health);
      System.out.println("Monster health: " + monster.health);
      System.out.println("Player, would you like to attack or defend?");
      playerChoice = scanner.nextLine();

      //check if the player made a valid choice
      if (playerChoice.equals("attack") || playerChoice.equals("defend")) {
        
        // check if player wants to attack  
        if (playerChoice.equals("attack")) {
          
          // invoke method to attack the monster!
          player.attack(monster);
         
          
        } else {
           player.defend();
        }
        //the monster should randomly make a decision
        monster.takeRandomAction(player);

      } else {
        // tell user it is an invalid choice
        System.out.println("Invalid choice. Try again.");
        continue;
      }
    }


    //after someone dies, display a winning or losing message to the player, depending on who lost
    if (player.health > 0) {
      System.out.println("Player wins!");
    } else {
      System.out.println("Monster wins!");
    }
    
  }  
}
import java.util.*;

public class Team4{

  public void printDinerSolutions() {
    ArrayList<Diner> diners = new ArrayList<>();
    
    Diner order1 = new Diner(6, "Tina", "White", "Mushroom Swiss Burger", "Ice cream", "Card");
    Diner order2 = new Diner(19, "Jordan","Yellow","Avocado Lime Burger", "Cake", "Cash");
    Diner order3 = new Diner(4, "Sergio", "Black", "Avocado Lime Burger", "Cake", "Cash");

    diners.add(order1);
    diners.add(order2);
    diners.add(order3);

    for(Diner person: diners) {
      System.out.println(person.toString());
    }
    
  }
  
}
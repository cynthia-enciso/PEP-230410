public class Team3 {
  void printDiners() {
    Diner diner1 = new Diner(5, "Eddie", "Red", "BLT Sandwich", "Cinnamon Sticks", "Cash");
    Diner diner2 = new Diner(18, "Christian", "White", "Cuban Sandwich", "Pie", "Cash");
    Diner diner3 = new Diner(14, "Antonio", "Yellow", "Grilled Cheese Sandwich", "Cinnamon Sticks","Cash");

    System.out.println(diner1.toString());
    System.out.println(diner2.toString());
    System.out.println(diner3.toString());
  }
}
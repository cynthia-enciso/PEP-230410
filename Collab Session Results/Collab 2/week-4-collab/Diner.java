public class Diner {

  // state
  private int seatNumber;
  private String name;
  private String shirtColor;
  private String entree;
  private String dessert;
  private String paymentType;

  // constructors
  public Diner() {}

  public Diner(int seatNumber, String name, String shirtColor, String entree, String dessert, String paymentType) {
    this.seatNumber = seatNumber;
    this.name = name;
    this.shirtColor = shirtColor;
    this.entree = entree;
    this.dessert = dessert;
    this.paymentType = paymentType;
  }

  // toString
  @Override 
  public String toString() {
    return "{" + 
      "Seat-Number:" + seatNumber +
      " Name:" + name +
      " Shirt-Color:" + shirtColor +
      " Entree:" + entree +
      " Dessert:" + dessert +
      " Payment-Type:" + paymentType +
      "}";  
  }
  
}
/*   Order #1  8	Wilma	Green	Pizza Roll	Ice cream	Card
SELECT * FROM pizza_place WHERE 
!(name LIKE 'R%') AND !(name *LIKE 'A%') AND  
dessert != 'Cake' AND seat_number < 15 AND 
entree = 'Pizza Roll' AND 
(seat_number % 2) = 0;

    Order #2   16	Nancy	Red	New York Pizza	Ice cream	Card

SELECT * FROM pizza_place WHERE shirt_color != 'Blue' AND *shirt_color != 'Black' AND entree != 'Deep Dish Pizza' AND name LIKE  '%a%' AND
dessert = 'Ice Cream' and name LIKE '%y';
  
    Order #3 //19	Norman	Yellow	New York Pizza	Cake	Cash
    
SELECT * FROM pizza_place 
WHERE dessert <> 'ice cream' AND
payment_type <> 'card' AND
Length(name) >3 AND
entree LIKE '%Pizza' AND
NOT(name LIKE '%i%' or name LIKE '%y%' )

*/
class Team2 {
  public void printDinersInfo() {
    Diner d1 = new Diner(8, "Wilma", "Green", "Pizza Roll", "Ice cream", "Card"); 
    Diner d3 = new Diner(16, "Nancy", "Red", "New York Pizza", "Ice cream", "Card");
    Diner d2 = new Diner(19, "Norman", "Yellow", "New York Pizza", "Cake", "Cash");
        
    System.out.println(d1.toString());
    System.out.println(d2.toString());
    System.out.println(d3.toString());

    
  }

}
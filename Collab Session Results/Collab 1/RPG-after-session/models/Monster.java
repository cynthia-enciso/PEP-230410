package models;

import java.util.ArrayList;
import java.util.Random;

public class Monster {

  // variables
  public String name;
  public int health;
  public String type;
  boolean isDefending;

  // constructors
  public Monster(String name, String type) {
    this.name = name;
    this.type = type;
    this.health = 100;
    this.isDefending = false;
  }

  // methods
  public void useHealthPotion() {
    this.health += 40;
  }

  public void attack(Player p){
    isDefending = false;
    //  * if the opponent is not currently defending, decrease opponent’s health by 20 
    // * otherwise, print out a statement that lets the user know their attack was blocked
    if(!p.isDefending){
      p.health = p.health - 20;
    }
    else{
    System.out.println( "Your attack was Blocked");
      
    }
  }

  public void printHealth() { 
    System.out.println(this.name + "'s health is at: " + this.health); 
  }
  
  public void defend() {
    this.isDefending = true; 
  }
  public void printInfo(){
    System.out.println("Name:" + name);
     System.out.println("Type:" + type);
    System.out.println("Health:" + health);
  }

  public void takeRandomAction(Player player) {
    Random randomVal = new Random();
    int randomized = randomVal.nextInt(101);
    if (randomized % 2 == 0) {
      this.attack(player);
    } else {
      this.defend();
    }
  }
}
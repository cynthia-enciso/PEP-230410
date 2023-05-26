package models;

import java.util.ArrayList;

public class Player {

  // variables
  public String name;
  public int health;
  public String type;
  boolean isDefending;

  // constructors
  public Player(String name, String type) {
    this.name = name;
    this.type = type;
    this.health = 100;
    this.isDefending = false;
  }

  // methods
  public void useHealthPotion() {
    this.health += 40;
  }

  public void attack(Monster m){
    isDefending = false;
    //  * if the opponent is not currently defending, decrease opponent’s health by 20 
    // * otherwise, print out a statement that lets the user know their attack was blocked
    if(!m.isDefending){
      m.health = m.health - 20;
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
}
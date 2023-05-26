package model;

/**
 * Client note: I didn't touch this file. It looks too important.
 */

public class Event {

  // state
  private int id;
  private String name;
  private String description;

  // constructors
  public Event() {
  }

  public Event(int id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Event(String name, String description) {
    this.name = name;
    this.description = description;
  }

  // behavior
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
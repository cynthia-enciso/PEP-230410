package dao;

import java.util.ArrayList;

import model.Event;
import util.Database;

/**
 * The EventDAO class uses a Database object to interact with the application's
 * database.
 */
public class EventDAO {

  // state
  Database database = new Database();

  /**
   * The getAllEvents method uses the Database object to return all the data from
   * the database.
   * 
   * @return an ArrayList of Event objects
   */
  public  ArrayList<Event> getAllEvents() {
    return database.getData();
  };

  /**
   * The addEvent method uses the Database object to add an Event object to the
   * database's data. This method must ensure the event has the next id value.
   * 
   * @param event is the Event object to add to the database.
   * 
   */
  public void addEvent(String name, String description) {
    database.getData().add(new Event(database.getNextId(), name, description));
  }

}
package service;

import java.util.ArrayList;

import model.Event;
import dao.EventDAO;

/**
 * The EventService class uses an EventDAO object to ask it to perform database
 * operations. This class provides any validation or business logic needed.
 */

public class EventService {

  // state
  EventDAO eventDAO = new EventDAO();

  /**
   * The getAllEvents method uses the EventDAO object to return all current events
   * in the database.
   * 
   * @return an ArrayList of Event objects
   */

  /**
   * The addEvent method uses the EventDAO object to add an event to the database.
   * - This method should also ensure that neither the name or description of the
   * event are empty strings.
   * - This method should also ensure the name of the event is 40 characters or
   * less.
   * 
   * @param An Event object
   */

}
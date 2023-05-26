package util;

import java.util.ArrayList;
import java.util.Collections;

import model.Event;

/**
 * The Database class represents the data the application keeps track of.
 */

public class Database {

  // state
  private ArrayList<Event> data = new ArrayList<Event>();
  private int id = 0;

  /*
   * Client note: I didn't touch this block of code!
   */
  {
   Collections.addAll(data,
        new Event(getNextId(), "Rock Climbing 101",
            "Learn the basics of scaling walls so you can do some authentic Spiderman roleplaying one day!"),
        new Event(getNextId(), "Group Zumba Class",
            "No dance experience necessary, we all look like goofballs, but it's fun."),
        new Event(getNextId(), "Hardcore Parkour Meetup",
            "Parkour! Please note we are not liable for any injuries sustained during the session."));
  }

  /**
   * The getData method provides a way for other classes to get access to our
   * database's data.
   * 
   * @return an ArrayList of Event objects
   */
    public ArrayList<Event> getData() {
      return this.data;
    }
  /**
   * The getNextId method provides a way to enable other classes to get the next
   * available id value. This method should ensure the id variable itself is
   * updated with the new value.
   * 
   * @return
   */
    public int getNextId() {
      return ++this.id;
    }

    // public void addEvent() {
    //   data.add(event);
    // }
}


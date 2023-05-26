package controller;

import io.javalin.Javalin;
import java.util.ArrayList;
import java.util.Collections;

import model.Event;
import service.EventService;

/**
 * The EventController class uses an EventService object to route information to
 * the application's business layer. It also contains syntax that helps the
 * application to render the appropriate visual content to the user.
 * 
 * NOTE: The red squigglies under `ctx ->` will NOT affect the program. Please
 * ignore them!
 */

public class EventController {

  /*
   * Client note: I removed something here... I don't remember what I did.
   */
  EventService eventService = new EventService();

  // start up web server
  public void startUp() {
    Javalin app = Javalin.create().start(8080);

    // endpoints
    app.get("/", ctx -> {
      ctx.redirect("/events");
    });

    app.get("/events", ctx -> {

      /*
       * Client note: I removed something here... I don't remember what I did.
       */
      
      
      ArrayList<Event> allEventsRetrieved = eventService.getAllEvents();

      ctx.render("events.jte", Collections.singletonMap("events", allEventsRetrieved));
    });

    app.post("/events", ctx -> {
      String name = ctx.formParam("name");
      String description = ctx.formParam("description");
      Event eventToAdd = new Event(name, description);
      /*
       * Client note: I removed something here... I don't remember what I did.
       */
      eventService.addEvent(name, description);

    });

  }

}
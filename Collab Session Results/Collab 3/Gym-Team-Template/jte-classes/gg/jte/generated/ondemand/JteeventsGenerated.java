package gg.jte.generated.ondemand;
import java.util.ArrayList;
import model.Event;
public final class JteeventsGenerated {
	public static final String JTE_NAME = "events.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,19,19,19,20,20,20,20,20,20,20,20,20,21,21,35};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ArrayList<Event> events) {
		jteOutput.writeContent("\n<html lang=\"en\">\n\n<head>\n<title>Home</title>\n<style>\nbody {\n  background-color: lightblue;\n}\n</style>\n</head>\n<body>\n\n    <h1>Library Events</h1>\n\n    ");
		for (Event event : events) {
			jteOutput.writeContent("\n        <li>");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(event.getId());
			jteOutput.writeContent(" - ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(event.getName());
			jteOutput.writeContent(": ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(event.getDescription());
			jteOutput.writeContent("</li>\n    ");
		}
		jteOutput.writeContent("\n\n    <h2>Add Event</h2>\n    <form method=\"post\" action=\"/events\">\n      <label>Event Name:</label><br>\n      <input type=\"text\" name=\"name\"><br>\n\n      <label>Event Description:</label><br>\n      <input type=\"text\" name=\"description\"><br>\n\n      <input type=\"submit\" value=\"Submit\">\n    </form>\n\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ArrayList<Event> events = (ArrayList<Event>)params.get("events");
		render(jteOutput, jteHtmlInterceptor, events);
	}
}

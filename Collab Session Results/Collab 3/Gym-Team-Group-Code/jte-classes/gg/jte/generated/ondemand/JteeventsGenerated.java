package gg.jte.generated.ondemand;
import java.util.ArrayList;
import model.Event;
public final class JteeventsGenerated {
	public static final String JTE_NAME = "events.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,8,8,150,150,153,153,153,154,154,154,156,156,156,158,158,168};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ArrayList<Event> events) {
		jteOutput.writeContent("\n\n\n    \n    ");
		jteOutput.writeContent("\n\n\n\n    <html lang=\"en\">\n\n    <head>\n        <title>Home</title>\n        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n        <link href=\"https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap\" rel=\"stylesheet\">\n        <style>\n            * {\n                margin: 0;\n                padding: 0;\n                border: 0;\n                font-family: sans-serif;\n            }\n\n            h1, .cardName {\n                font-family: 'Permanent Marker', cursive;\n            }\n            body {\n                background-color: #3f5bba;\n                width: 100%;\n            }\n\n            header {\n                background-color: #ffdb59;;\n                width: 100%;\n                box-shadow: #34498c 0px 2px 10px 5px;\n                display: flex;\n                justify-content: center;\n                align-items: center;\n                height: 10vh;\n                margin-bottom: 20px;\n            }\n\n            form {\n                margin: auto;\n                width: 60%;\n                display: flex;\n                justify-content: space-between;\n                align-items: center;\n                background-color: #7789c2;\n                border-radius: 20px;\n                padding: 10px 20px;\n                min-width: 750px;\n\n            }\n\n            hidden {\n                height: 50px;\n                width: 100%;\n                visibility:hidden;\n            }\n\n            div {\n                margin: auto;\n                display: flex;\n                flex-wrap: wrap;\n                justify-content: space-around;\n                width: 80%;\n                min-width: 750px;\n                row-gap: 20px;\n                column-gap: 20px;\n            }\n            \n            input[type=\"text\"] {\n                height: 20px;\n                border-radius: 3px;\n            }\n\n            #button {\n                padding: 5px;\n                border-radius: 5px;\n                background-color: #4ce847;\n                border: #39a635 solid 3px;\n                font-weight: bold;\n            }\n\n            card {\n                background-color: white;\n                border-radius: 10px 10px 5px 5px;\n                width: 25%;\n                text-align: center;\n                box-shadow: #34498c 0px 5px 5px 5px;\n\n            }\n\n            card-top {\n                background-color: #ffdb59;\n                width: 100%;\n                display: block;\n                border-radius: 10px 10px 0  0;\n                position: relative;\n                height: 35%\n            }\n\n            card > * {\n                padding: 10px 0;\n            }\n\n            .cardName {\n                margin: 20px;\n                font-size: 20px;\n            }\n\n            .cardId {\n                position: absolute;\n                top: 8px;\n                left: 8px;\n            }\n            .cardDescription {\n                margin: 10px;\n            }\n        </style>\n    </head>\n\n    <body>\n\n        <header>\n            <h1>Gym Events</h1>\n        </header>\n\n        <form method=\"post\" action=\"/events\">\n            <fieldset>\n                <label>Event Name:</label>\n                <input type=\"text\" name=\"name\">\n            </fieldset>\n\n            <fieldset>\n                <label>Event Description:</label>\n                <input type=\"text\" name=\"description\">\n            </fieldset>\n            \n            <input type=\"submit\" value=\"Add Event\" id=\"button\">\n        </form>\n\n        <hidden>f</hidden>\n\n        <div>\n          ");
		for (Event event : events) {
			jteOutput.writeContent("\n          <card>\n                <card-top>\n                    <p class=\"cardId\">");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(event.getId());
			jteOutput.writeContent("</p>\n                    <p class=\"cardName\">");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(event.getName());
			jteOutput.writeContent("</p>\n                </card-top>\n                <p class=\"cardDescription\">");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(event.getDescription());
			jteOutput.writeContent("</p>\n            </card>\n          ");
		}
		jteOutput.writeContent("\n        </div>\n\n        \n\n    </body>\n\n    </html>\n\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ArrayList<Event> events = (ArrayList<Event>)params.get("events");
		render(jteOutput, jteHtmlInterceptor, events);
	}
}

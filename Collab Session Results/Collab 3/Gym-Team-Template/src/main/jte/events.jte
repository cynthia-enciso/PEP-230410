@import java.util.ArrayList
@import model.Event

@param ArrayList<Event> events



    
    <!-- This code is atrocious, I'm sorry you had to see this. -->



    <html lang="en">

    <head>
        <title>Home</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
        <style>
            * {
                margin: 0;
                padding: 0;
                border: 0;
                font-family: sans-serif;
            }

            h1, .cardName {
                font-family: 'Permanent Marker', cursive;
            }
            body {
                background-color: #3f5bba;
                width: 100%;
            }

            header {
                background-color: #ffdb59;;
                width: 100%;
                box-shadow: #34498c 0px 2px 10px 5px;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 10vh;
                margin-bottom: 20px;
            }

            form {
                margin: auto;
                width: 60%;
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: #7789c2;
                border-radius: 20px;
                padding: 10px 20px;
                min-width: 750px;

            }

            hidden {
                height: 50px;
                width: 100%;
                visibility:hidden;
            }

            div {
                margin: auto;
                display: flex;
                flex-wrap: wrap;
                justify-content: space-around;
                width: 80%;
                min-width: 750px;
                row-gap: 20px;
                column-gap: 20px;
            }
            
            input[type="text"] {
                height: 20px;
                border-radius: 3px;
            }

            #button {
                padding: 5px;
                border-radius: 5px;
                background-color: #4ce847;
                border: #39a635 solid 3px;
                font-weight: bold;
            }

            card {
                background-color: white;
                border-radius: 10px 10px 5px 5px;
                width: 25%;
                text-align: center;
                box-shadow: #34498c 0px 5px 5px 5px;

            }

            card-top {
                background-color: #ffdb59;
                width: 100%;
                display: block;
                border-radius: 10px 10px 0  0;
                position: relative;
                height: 35%
            }

            card > * {
                padding: 10px 0;
            }

            .cardName {
                margin: 20px;
                font-size: 20px;
            }

            .cardId {
                position: absolute;
                top: 8px;
                left: 8px;
            }
            .cardDescription {
                margin: 10px;
            }
        </style>
    </head>

    <body>

        <header>
            <h1>Gym Events</h1>
        </header>

        <form method="post" action="/events">
            <fieldset>
                <label>Event Name:</label>
                <input type="text" name="name">
            </fieldset>

            <fieldset>
                <label>Event Description:</label>
                <input type="text" name="description">
            </fieldset>
            
            <input type="submit" value="Add Event" id="button">
        </form>

        <hidden>f</hidden>

        <div>
          @for(Event event : events)
          <card>
                <card-top>
                    <p class="cardId">${event.getId()}</p>
                    <p class="cardName">${event.getName()}</p>
                </card-top>
                <p class="cardDescription">${event.getDescription()}</p>
            </card>
          @endfor
        </div>

        

    </body>

    </html>



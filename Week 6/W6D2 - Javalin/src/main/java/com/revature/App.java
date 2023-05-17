package com.revature;

import java.util.ArrayList;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class App 
{
    public static Database db;
    public static void main( String[] args ) {
        // setup
        db = new Database();
        db.init();

        Controller controller = new Controller();
        controller.setupAPI();
    }

    
}

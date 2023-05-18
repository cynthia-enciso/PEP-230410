package com.revature;

import com.revature.controller.PetController;
import com.revature.dao.PetDAO;
import com.revature.dao.PetDAOImpl;

public class App 
{
    public static void main( String[] args )
    {
        PetController controller = new PetController();
        controller.setupAPI();

    }

}

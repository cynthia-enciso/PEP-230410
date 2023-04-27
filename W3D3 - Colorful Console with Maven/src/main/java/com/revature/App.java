package com.revature;

import com.diogonunes.jcolor.AnsiFormat;
import static com.diogonunes.jcolor.Attribute.*;

public class App 
{

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main( String[] args )
    {
        System.out.println(ANSI_PURPLE + "Hello world" + ANSI_RESET);

        AnsiFormat exampleFormat = new AnsiFormat(TEXT_COLOR(199, 145, 14), BACK_COLOR(235, 202, 122), BOLD(), ITALIC());
        System.out.println(exampleFormat.format("\nNow look at it. Fancy!"));

    }
}

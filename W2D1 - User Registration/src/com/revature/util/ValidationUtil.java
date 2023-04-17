package com.revature.util;

import java.util.regex.*;

public class ValidationUtil {

    public static final Pattern SPECIAL_CHARACTERS = Pattern.compile("[~`!@#*$%^&]");
    
    // create method that checks for length of text to be in a specific range
    public static boolean lengthIsValid(int min, int max, String text) {
        if (text.length() >= min && text.length() <= max) {
            return true;
        } else {
            return false;
        }
    }

    // create method that checks if text contains certain special characters
    public static boolean hasSpecialCharacters(String text) {
        Matcher matcher = SPECIAL_CHARACTERS.matcher(text);
        return matcher.find();
    }
}

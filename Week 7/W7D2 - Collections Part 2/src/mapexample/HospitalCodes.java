package mapexample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

//Hospitals often use code names to alert staff to an emergency. You are a new staff member
// and are trying to remember them all. So you have decided to store them in your notebook
// to remember them.

public class HospitalCodes {
    public static void main(String[] args) {
        // https://stackoverflow.com/questions/8261075/adding-multiple-entries-to-a-hashmap-at-once-in-one-statement
        // adding multiple values at once to map
        // 1. use Map.of which returns an immutable map
        Map<String, String> immutableMap = Map.of(
        "BLUE", "critical medical emergency",
        "RED", "fire or smoke",
        "BLACK", "bomb threat",
        "VOILET", "violet person",
        "ORANGE", "hazardous spill",
        "BROWN", "severe weather"
        );
        
        // 2. add it to a regular map
        HashMap<String, String> notebook = new HashMap<>(immutableMap);

        // add a code to your notebook
        notebook.put("PINK", "infant emergency");
        System.out.println(notebook);

        // see what value maps to the code ORANGE
        System.out.println("Emergency for code ORANGE: " +  notebook.get("ORANGE"));

        // iterating, three ways
        // over keys
        System.out.println("\nPrinting the keys (codes):");
        Set<String> codes = notebook.keySet();
        for (String code : codes) {
            System.out.println(code);
        }

        // over values
        System.out.println("\nPrinting the values (emergencies):");
        Collection<String> emergencies = notebook.values();
        for (String emergency : emergencies) {
            System.out.println(emergency);
        }
        
        // over entries
        System.out.println("\nPrinting the entries:");
        Set<Entry<String, String>> entries = notebook.entrySet();
        for (Entry<String, String> entry : entries) {
			System.out.println(entry);
		}


    }
}

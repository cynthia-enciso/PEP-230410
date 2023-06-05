package reflection;

import java.lang.reflect.*;
import java.util.ArrayList;

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/package-summary.html
// https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html
// https://docs.oracle.com/javase/tutorial/reflect/
// https://docs.oracle.com/javase/tutorial/reflect/class/classMembers.html

@SuppressWarnings("unchecked")
public class UsingReflection {
    public static void main(String[] args) throws Exception {
        getClassInfo();
    }

    public static void getClassInfo() throws Exception {
        // get class object
        Class<Database> databaseClass = Database.class;

        // get class member information: https://docs.oracle.com/javase/tutorial/reflect/class/classMembers.html
        System.out.format("Class:%n  %s%n%n", databaseClass.getSimpleName());
        printMembers(databaseClass.getDeclaredConstructors(), "Constuctors");
        printMembers(databaseClass.getDeclaredFields(), "Fields");
        printMembers(databaseClass.getDeclaredMethods(), "Methods");

        // get specific member
        Method specificMethod = databaseClass.getDeclaredMethod("addFoodItem", FoodItem.class);
        
        // invoke it (if method)
        Database db = new Database();
        specificMethod.invoke(db, new FoodItem("Hoagie", 2.99));

        Field specificField = databaseClass.getDeclaredField("data");
        specificField.setAccessible(true);
        ArrayList<FoodItem> dataRetrieved = (ArrayList<FoodItem>) specificField.get(db);
        System.out.println(dataRetrieved);

        // do my changes affect the actual class?
        Field specificStaticField = databaseClass.getDeclaredField("value");
        specificStaticField.set(db, 2);
        System.out.println(Database.value); // 2

    }

    // Member interface:https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Member.html
    // requires that implementing subtypes include methods that return specific metadata
    private static void printMembers(Member[] mbrs, String s) {
        System.out.format("%s:%n", s);
        
        // downcast from supertype to subtype in order to get subtype specific method (toGenericString)
        for (Member mbr : mbrs) {
            if (mbr instanceof Field) {
                System.out.format("  %s%n", ((Field)mbr).toGenericString());
            } else if (mbr instanceof Constructor) {
                System.out.format("  %s%n", ((Constructor<Database>)mbr).toGenericString()); // no args

            } else if (mbr instanceof Method) {
                System.out.format("  %s%n", ((Method)mbr).toGenericString());   
            } 
        }

        // add newline
        System.out.format("%n");
    }
}

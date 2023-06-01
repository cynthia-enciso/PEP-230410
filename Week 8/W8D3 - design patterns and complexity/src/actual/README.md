# Factory Method Pattern

Rather than having a single class be responsible for all object creation (SimpleAttractionFactory), have an
abstract method within the District class that requires subtypes of a District to produce the specific type
they need. 

Why would we do this? Think about adding another Attraction class to your project.
You can make the attraction available as a type of object to use by extending the District class.
This follows Open/Close Principle. You do not modify any files, you add a file.
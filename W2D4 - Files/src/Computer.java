import java.util.ArrayList;
import java.util.Random;

public class Computer {
    
    // characteristic
    public FakeFile[] filesystem = new FakeFile[3];

    public void initializeFileSystem() {
        // create files and add to filesystem
        ArrayList<String> text1 = new ArrayList<>();
        text1.add("File 1");
        text1.add("username: cooldude1");
        text1.add("password: password1234");
        FakeFile file1 = new FakeFile(text1);
        filesystem[0] = file1;

        ArrayList<String> text2 = new ArrayList<>();
        text2.add("File 2");
        text2.add("note to self: pay bills on Friday");
        FakeFile file2 = new FakeFile(text2);
        filesystem[1] = file2;

        ArrayList<String> text3 = new ArrayList<>();
        text3.add("File 3");
        text3.add("Hello Tammy,");
        text3.add("Regarding our last correspondence");
        text3.add("I would like to move forward with our date.");
        text3.add("Can I call you this weekend?");
        text3.add("Best,");
        text3.add("Philip");
        FakeFile file3 = new FakeFile(text3);
        filesystem[2] = file3;
    }

    public void accidentallyDownloadMalware() {
        // get random file
        Random random = new Random();
        int index = random.nextInt(filesystem.length); // range is 0 - last index (value of length is NOT in range)

        // corrupt random file
        filesystem[index] = null;
    }
}

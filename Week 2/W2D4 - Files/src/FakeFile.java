import java.util.ArrayList;

public class FakeFile {
    
    // characteristics
    public ArrayList<String> textInFile = new ArrayList<>();

    // constructor
    public FakeFile() {
    }

    public FakeFile(ArrayList<String> textInFile) {
        this.textInFile = textInFile;
    }

    // behavior
    public void readFrom() throws FileAccessException {
        System.out.println("-----------------");
        for (String line : textInFile) {
            System.out.println(line);
        }
    }

    public void writeTo(String text) throws FileAccessException {
        textInFile.add(text);
    }

}

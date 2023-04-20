import java.util.Scanner;

public class App {
    public static void main(String[] args) {
         // create scanner object
        Scanner scanner = new Scanner(System.in);

        // create computer and initalize filesystem
        Computer pc = new Computer();
        pc.initializeFileSystem();

        // welcome user
        System.out.println("You log on to your computer.");

        // read the files
        System.out.println("\nYou decide to read through your files:");
        for (FakeFile file : pc.filesystem) {
            try {
                file.readFrom();
            } catch (FileAccessException e) {
                e.printStackTrace();
            }
        }

        // introduce the malware
        System.out.println("\n You get bored and check your email.");
        System.out.println("There's an email that has a link to download a cool app!");
        System.out.println("You download the app.");
        pc.accidentallyDownloadMalware();
        System.out.println("You try to run the app, but it doesn't work...");


        loop:
        while(true) {
            System.out.println("\nYou get bored and want to write to a file. Which file do you choose?");
            System.out.println("1) File 1");
            System.out.println("2) File 2");
            System.out.println("3) File 3");
            System.out.println("4) Go do something else (quit)");

            int input = scanner.nextInt();

            // break early if user chooses to quit
            if (input == 4) {
                break loop;
            }

            System.out.println("And what do you want to write? Enter your text:");
            scanner.nextLine(); // consume newline character
            String text = scanner.nextLine();

            try {
                switch(input) {
                    case 1: 
                    case 2: 
                    case 3: pc.filesystem[input - 1].writeTo(text);
                            break;
                    default: System.out.println("Invalid selection.");
                }
            } catch(NullPointerException exception) {
                System.out.println("File is corrupted! You can't read it and wonder why.");
                continue; // skip to the next iteration!
            } catch(FileAccessException exception) {
                exception.printStackTrace();
            }

            System.out.println("\nChecking the file, you see:");
            try {
                pc.filesystem[input - 1].readFrom();
            } catch (FileAccessException e) {
                e.printStackTrace();
            }

            
        }

        scanner.close();
    }
}

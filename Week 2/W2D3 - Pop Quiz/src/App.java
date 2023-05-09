import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // scanner object
        Scanner scanner = new Scanner(System.in);

        // create a quiz and initialize
        Quiz quiz = new Quiz();
        quiz.initalize(
            new Question("Java is interpreted.", "True", "False"),
            new Question("Which of the following naming conventions is NOT used in Java?", "SaRcAsM-cAsE", "UPPER_SNAKE_CASE", "PascalCase"),
            new Question("Which of the following is a scope in Java?", "Instance", "Built-In", "Tactical", "Shared")
        );

        // create a player and initialize
        Player player;
        System.out.println("Would you like to save your score? Y/N");
        String initPlayer = scanner.nextLine();

        if (initPlayer.equals("Y")) {
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter gender (for custom experience):");
            String gender = scanner.nextLine();
            player = new Player(username, gender);
        } else {
            player = new Player();
        }

        // play the quiz
        for(Question question : quiz.questionsList) {
            // print question
            System.out.println("-----------------------");
            System.out.println(question.questionText);
            question.printAnswersRandomly();

            // get user response
            String guess = scanner.nextLine();

            // compare and assign point, if player is correct
            if (question.answerList.indexOf(guess) == 0) {
                player.score++;
            }
        }
        // show user their results
        System.out.println("Quiz is over! Here is your score: " + player.score);
        switch(player.gender.toLowerCase()) {
            case "male": System.out.println("Ciao, my dude!");
                        break;
            case "female": System.out.println("Adios, señorita!");
                        break;
            default: System.out.println("See you later, alligator!");
        }
            
        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.Random;

public class Question {
    
    // instance variables
    public String questionText;
    // first answer always correct one
    public ArrayList<String> answerList = new ArrayList<>();

    // constructor
    public Question(String questionText, String... answers) {
        this.questionText = questionText;

        for(String answer : answers) {
            this.answerList.add(answer);
        }
    }

    // instance methods
    public void printAnswersRandomly() {
        // create clone to manipluate
        ArrayList<String> listClone = new ArrayList<>();
        for (String answer : answerList) {
            listClone.add(answer);
        }

        // create necessary variables
        Random random = new Random();
        int index;
        int size = listClone.size();

        // get a random answer, then remove
        for (int i = 0; i < size; i++) {
            index = random.nextInt(listClone.size());
            System.out.println(listClone.get(index));
            listClone.remove(listClone.get(index));
        }
    }
}

import java.util.ArrayList;
public class Quiz {
    
    // should be made up of questions
    // questions
    ArrayList<Question> questionsList = new ArrayList<>();

    // instance method
    // initialize
    public void initalize(Question... questions) {
        for(Question question : questions) {
            this.questionsList.add(question);
        }
    }
}

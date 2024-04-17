import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Quiz> quizzes = new ArrayList<>();

        quizzes.add(new Quiz());

        HashMap<String, Boolean> answers = new HashMap<>();

        answers.put("1", false);
        answers.put("2", true);
        answers.put("3", false);
        answers.put("4", false);

        quizzes.get(0).addQuestions("1 + 1", answers);

        System.out.println(quizzes);
    }
}
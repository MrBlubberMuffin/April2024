import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> answers;
    private ArrayList<Boolean> correct;
    private Quiz parentQuiz;

    public Question(String _question, Quiz parent) {
        question = _question;
        answers = new ArrayList<String>();
        correct = new ArrayList<Boolean>();
    }

    public Question(String question, ArrayList<String> answers, ArrayList<Boolean> correct, Quiz parentQuiz) {
        this.question = question;
        this.answers = answers;
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public ArrayList<Boolean> getCorrect() {
        return correct;
    }

    public Quiz getParentQuiz() {
        return parentQuiz;
    }

    public void addOption(String option, boolean _correct) {
        answers.add(option);
        correct.add(_correct);
    }

    public String toString() {
        return question + "\n" + answers + "\n" + correct;
    }

}
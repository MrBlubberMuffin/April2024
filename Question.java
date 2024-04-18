import java.util.ArrayList; // IMPORT

public class Question {
    private String question;
    private ArrayList<String> answers;
    private ArrayList<Boolean> correct;
    private Quiz parentQuiz;

    public Question() {
        question = "";
        answers = new ArrayList<String>();
        correct = new ArrayList<Boolean>();
        parentQuiz = new Quiz();
    }

    public Question(Quiz quiz) {
        question = "";
        answers = new ArrayList<String>();
        correct = new ArrayList<Boolean>();
        parentQuiz = quiz;
    }

    public Question(String _question, Quiz parent) {
        question = _question;
        answers = new ArrayList<String>();
        correct = new ArrayList<Boolean>();
        parentQuiz = parent;
    }

    public Question(String question, ArrayList<String> answers, ArrayList<Boolean> correct, Quiz parent) {
        this.question = question;
        this.answers = answers;
        this.correct = correct;
        parentQuiz = parent;
    }

    public void setQuestion(String _question) {
        question = _question;
    }

    public void changeAnswerValue(String answer, boolean value) {
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).equals(answer)) {
                correct.set(i, value);
            }
        }
    }

    public void changeAnswer(String answer, String newAnswer) {
        for (String answerIndex : answers) {
            if (answerIndex.equals(answer)) {
                answerIndex = newAnswer;
            }
        }
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
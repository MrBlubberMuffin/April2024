import java.util.ArrayList;

public class Quiz {
    private String quizName;
    private String courseName;
    private ArrayList<Question> questions;

    public Quiz() {
        quizName = "";
        courseName = "";
        questions = new ArrayList<Question>();
    }

    public Quiz(String name, String course) {
        quizName = name;
        courseName = course;
        questions = new ArrayList<Question>();
    }

    public void setQuizName(String name) {
        quizName = name;
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public String getQuizName() {
        return quizName;
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(String question) {
        questions.add(new Question(question, this));
    }

    //if quiz has these question marks as these attributes, that means there is no quiz with the given name
    public static Quiz getQuiz(String name, ArrayList<Quiz> quizzes) {
        for (Quiz quiz : quizzes) {
            if (quiz.getQuizName().equals(name)) {
                return quiz;
            }
        }
        return new Quiz("???", "???");
    }

    public String toString() {
        return
                quizName + "\n" +
                        courseName + "\n" +
                        questions;
    }
}
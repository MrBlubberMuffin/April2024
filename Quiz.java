import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Quiz {
    private String quizName;
    private String courseName;
    private HashMap<String, HashMap<String, Boolean>> questions;

    public Quiz() {
        quizName = "";
        courseName = "";
        questions = new HashMap<>();
    }

    public Quiz(String name, String course) {
        quizName = name;
        courseName = course;
        questions = new HashMap<>();
    }

    public String getQuizName() {
        return quizName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setQuizName(String name) {
        quizName = name;
    }

    public void setCourseName(String course) {
        courseName = course;
    }

    public HashMap<String, HashMap<String, Boolean>> getQuestions() {
        return questions;
    }

    public void addQuestions(String question, HashMap<String, Boolean> answers) {
        questions.put(question, answers);
    }

    public String toString() {
        return
                quizName + "\n" +
                courseName + "\n" +
                questions;
    }
}
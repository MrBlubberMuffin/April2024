import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		ArrayList<Quiz> quizzes = new ArrayList<>();
		File Quizzes = new File("Quizzes.txt");

		Quiz quiz = new Quiz("QUIZ", "Math")
		quizzes.add(quiz);

		ArrayList<String> answers = new ArrayList<>();
		ArrayList<Boolean> correct = new ArrayList<>();

		answers.add("1");
		answers.add("2");
		answers.add("3");
		answers.add("4");
		correct.add(false);
		correct.add(true);
		correct.add(false);
		correct.add(false);

		quizzes.get(0).addQuestion("1 + 1", answers, correct);
		quizzes.get(0).setQuizName("QUIZ");
		quizzes.get(0).setCourseName("Math");

		System.out.println(quizzes);
	}

	public static void createTextFile(File file) {
		try {
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName() + "\nPath: " + file.getPath());
			} else {
				System.out.println(file.getName() + " file already Exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}

	public static String readTextFile(File file) throws FileNotFoundException {
		Scanner myReader = new Scanner(file);
		StringBuilder data = new StringBuilder();
		
		Quiz currentQuiz;
		String currentQuestion;
		
		if (myReader.hasNextLine()) {
			for (int i = 0; i < myReader.length(); i++) {
				if (myReader.charAt(i) == '@') { //quiz name
					for (int j = i+1; j < myReader.length(); j++) {
						if (myReader.charAt(j) == '&') { //end of quiz name
							currentQuiz = Quiz.getQuiz(myReader.substring(i, j));
							for (int k = j + 1; k < myReader.length(); k++) {
								if (myReader.charAt(k) == '#') {
									currentQuestion = Quiz.getQuiz(myReader.substring(j, k));
									i = k;
								}
							}
						}
					}
				}
			}
		}

		if (myReader.hasNextLine()) {
			data.append(myReader.nextLine()).append(" ");
			data.append("#");
		} else {
			return "###";
		}

		return data.toString();
	}
	//@ is for quiz name, & symbol for course name, # for questiosn, - for answers, = for answer correctness
	public static void writeTextFile(File file) {
		try {
			FileWriter myWriter = new FileWriter(file, true);
			myWriter.append(quiz.getQuizName()).append(" ").append(quiz.getCourseName()).append(" ");

			for (Quiz quiz : quizzes) {
				myWriter.append("@").append(quiz.getQuizName()).append("&").append(quiz.getCourseName);
				
				quiz.getQuestions().forEach((key, value) -> {
					myWriter.append("#").append(key);
					value.forEach((k, v) -> {
						myWriter.append("-").append(k).append("=").append(v)
					});
				});
			}

			myWriter.close();
			System.out.println("Successfully wrote to file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
}
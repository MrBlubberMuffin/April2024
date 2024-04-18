import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		File Quizzes = new File("Quizzes.txt");

		ArrayList<Quiz> quizzes = new ArrayList<>();

		quizzes.add(new Quiz("QUIZ", "Math"));

		quizzes.get(0).addQuestion("1 + 1");

		quizzes.get(0).getQuestions().get(0).addOption("1", false);
		quizzes.get(0).getQuestions().get(0).addOption("2", true);
		quizzes.get(0).getQuestions().get(0).addOption("3", false);
		quizzes.get(0).getQuestions().get(0).addOption("4", false);

		System.out.println(quizzes + "\n\n\n");
		writeTextFile(Quizzes, quizzes);
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
		if (myReader.hasNextLine()) {
			data.append(myReader.nextLine()).append(" ");
			data.append("#");
		} else {
			return "###";
		}
		return data.toString();
	}

	public static void writeTextFile(File file, ArrayList<Quiz> quizzes) {
		try {
			FileWriter myWriter = new FileWriter(file, true);

			for (Quiz quiz : quizzes) {
				myWriter.append("&").append(quiz.getQuizName()).append("@").append(quiz.getCourseName());
				for (Question question : quiz.getQuestions()) {
					myWriter.append("#").append(question.getQuestion());
					for (int i = 0; i < question.getAnswers().size(); i++) {
						myWriter.append("|").append(question.getAnswers().get(i)).append("{").append(String.valueOf(question.getCorrect().get(i)));
					}
				}
			}

			myWriter.close();
			System.out.println("Successfully wrote to file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
}
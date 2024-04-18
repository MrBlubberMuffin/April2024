import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File Quizzes = new File("Quizzes.txt");
		createTextFile(Quizzes);

		System.out.println(" -------------------- >>> WELCOME TO QUIZZY <<< --------------------");
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

	public static ArrayList<Quiz> loadData() {
		ArrayList<Quiz> quizzes = new ArrayList<>();





		return quizzes;
	}

	public static String readFile(File file) throws FileNotFoundException {
		Scanner myReader = new Scanner(file);
		StringBuilder data = new StringBuilder();
		if (myReader.hasNextLine()) {

			for (int i = 0; i < file.length(); i++) {
				data.append(myReader.nextLine());
			}

		} else {
			return null;
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
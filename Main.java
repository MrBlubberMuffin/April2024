package AlexChan;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		File Quizzes = new File("Quizzes.txt");

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

	public static void writeTextFile(File file) {
		try {
			FileWriter myWriter = new FileWriter(file, true);
			myWriter.append(quiz.getQuizName()).append(" ").append(quiz.getCourseName()).append(" ");
			//for (int i = 0; i < quiz.getQuestions().size(); i++) {
				//GO THROUGH QUESTIONS AND WRITE THEM ON THE FILE
				//format, seperated by spaces and hastags

			//}
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
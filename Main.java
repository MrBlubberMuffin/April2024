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
		
		Quiz currentQuiz;
		String currentQuestion;
		
		if (myReader.hasNextLine()) {
			for (int i = 0; i < myReader.length(); i++) {
				if (myReader.charAt(i) == '@') { //quiz name
					for (int j = i+1; j < myReader.length(); j++) {
						if (myReader.charAt(j) == '&') { //end of quiz name
							currentQuiz = Quiz.getQuiz(myReader.substring(i, j);
							
							for (int k = j + 1; k < myReader.length(); k++) {
								if (myReader.charAt(k) == '#') {
										currentQuestion = Quiz.getQuiz(myReader.substring(j, k));
										i = k;
								}
							}
							
						}
					}
				}
<<<<<<< HEAD


=======
				
				)
				
>>>>>>> fa276175f34c570c6b2e811cd0d34a9e2dd11ecc
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
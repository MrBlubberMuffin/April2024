import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

//MAIN
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File Quizzes = new File("Quizzes.txt");
		createTextFile(Quizzes);

		System.out.print("""
                -------------------- >>> WELCOME TO QUIZZY <<< --------------------
                
                This is your new start.
                
                Let's get those grades up!
                """);

		boolean valid = true;

		do {
			System.out.println("Enter a command (type 'help' to see commands): ");
			scanner.nextLine();

			String input = scanner.nextLine();

			if (input.equals("help")) {
				instructions();
			} else {
				checkInput(input);
			}
		} while (!valid);
	}

	public static void checkInput(String input) {
		switch (input) {
			case "/quit":
				System.exit(0);
				break;
			case "/manage":
				manageQuizzes();
				break;
			case "/play":
				playQuizzes();
				break;
		}
	}

	public static void manageQuizzes() {

	}

	public static void playQuizzes() {

	}

	public static void instructions() {
		System.out.println("""
                
                Main commands:
                
                /quit                               Exit program
                /manage                             Manage quizzes
                /play                               Play a quiz
                
                Manage commands:
                
                /delete                             Delete a quiz
                /add                                Add a quiz
                /manage                             Manage a specific quiz
                /back                               Go back to main menu
                
                """);
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
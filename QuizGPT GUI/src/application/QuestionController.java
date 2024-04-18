package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QuestionController {
	
	@FXML
	Label question;
	TextField questionChange;
	TextField EnterQuestion;
	TextField addAnswer1;
	TextField addAnswer2;
	TextField addAnswer3;
	TextField addAnswer4;
	TextField enterQuestion;
	TextField addTitle;
	Button backFunc;
	Button bFunc;
	
	Quiz test = new Quiz();
	Question testQ = new Question();
	ArrayList<String> answers = new ArrayList<String>();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToQ1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Question1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goBack(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Modify.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void questionString() {
		question.setText("Question: hi there");
	}
	public void addTitle() {
		String title = addTitle.getText();
		test.setQuizName(title);
	}
	public void addQuestion() {
		String question = enterQuestion.getText();
	}
	public void answer1() {
		String answer1 =addAnswer1.getText();
		System.out.println(answer1);
		answers.add(answer1);
	}
	public void answer2() {
		String answer2 =addAnswer2.getText();
		answers.add(answer2);
	}
	public void answer3() {
		String answer3 =addAnswer3.getText();
		answers.add(answer3);
	}
	public void answer4() {
		String answer4 =addAnswer4.getText();
		answers.add(answer4);
	}
	
	
	public void changeTextQ() {
		String change = questionChange.getText();
		
	}
	
}

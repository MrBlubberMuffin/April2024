package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class QuestionController {
	
	@FXML
	Label question;
	TextField questionChange;
	
	
	public void questionString() {
		question.setText("Question: hi there");
	}
	
	public void changeTextQ() {
		String change = questionChange.getText();
	}
}

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlTitleScreen {
	
	@FXML
	Button playButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToModify(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Modify.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToFirst(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Question1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToList(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void switchToTitleScreen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void quit() {
		
	}
}

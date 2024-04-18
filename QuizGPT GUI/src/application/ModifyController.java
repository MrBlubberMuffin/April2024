package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ModifyController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void questionAdd(ActionEvent event) throws IOException {
		//Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void goBack(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToDemo(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Demo YRHacks.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToSlot1(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Question.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToTitleScreen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Modify.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

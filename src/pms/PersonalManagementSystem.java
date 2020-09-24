package pms;

import user.User;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.geometry.*;

public class PersonalManagementSystem extends Application{
	@Override
	public void start(Stage primaryStage){
		//Pane pane = new Pane();
		
		
		
		Scene scene = new Scene(new loginMenu(), 400, 400);
		
		primaryStage.setTitle("Personal Management System");
		//primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	ArrayList<User> users= new ArrayList<User>();
	
	class loginMenu extends GridPane{
		TextField username = new TextField();
		TextField password = new TextField();
		Label usernameLabel = new Label("Username: ");
		Label passwordLabel = new Label("Password: ");
		
		loginMenu(){
			//super(8);
			this.setPrefSize(100, 50);
			this.setMaxSize(100, 50);
			this.setMinSize(100, 50);
			this.setAlignment(Pos.CENTER);
			
			username.setPrefSize(100, 24);
			username.setMaxSize(100, 24);
			username.setMinSize(100, 24);
			
			password.setPrefSize(100, 24);
			password.setMaxSize(100, 24);
			password.setMinSize(100, 24);
			
			username.setPromptText("Username");
			password.setPromptText("Password");
			
			this.add(usernameLabel, 0, 0);
			this.add(passwordLabel, 0, 1);
			this.add(username, 1, 0);
			this.add(password, 1, 1);
			//this.getChildren().addAll(username, password);
		}
	}
}
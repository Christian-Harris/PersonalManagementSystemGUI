package menu;

import user.User;

import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.geometry.Pos;

public class NewUserMenu extends GridPane{
	Label newUser = new Label("New User");
	Label usernameLabel = new Label("Username:");
	Label passwordLabel = new Label("Password:");
	TextField username = new TextField();
	TextField password = new TextField();
	Button create = new Button("Create");
	
	public NewUserMenu(){
		this.setStyle("-fx-background-color: #39DEC2; -fx-border-color: grey; -fx-border-width: 12");
		this.setPrefSize(100, 50);
		this.setMaxSize(400, 200);
		this.setMinSize(100, 50);
		this.setAlignment(Pos.CENTER);
		
		usernameLabel.setPrefSize(100, 24);
		usernameLabel.setMaxSize(400, 96);
		usernameLabel.setMinSize(100, 24);
		
		passwordLabel.setPrefSize(100, 24);
		passwordLabel.setMaxSize(400, 96);
		passwordLabel.setMinSize(100, 24);
		
		username.setPrefSize(100, 24);
		username.setMaxSize(400, 96);
		username.setMinSize(100, 24);
		
		password.setPrefSize(100, 24);
		password.setMaxSize(400, 96);
		password.setMinSize(100, 24);
		
		username.setPromptText("Username");
		password.setPromptText("Password");
		
		this.add(newUser, 0, 0);
		this.add(usernameLabel, 0, 1);
		this.add(username, 1, 1);
		this.add(passwordLabel, 0, 2);
		this.add(password, 1, 2);
		this.add(create, 0, 3);
	}
}
package pms;

import user.User;
import myExceptions.*;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.*;

public class PersonalManagementSystem extends Application{
	@Override
	public void start(Stage stage){
		//Temporarily hard coded admin user.
		try{
			this.addUser("Admin", "password");
		}catch(UserAlreadyExistsException ex){
				System.out.print(ex.getUsername());
		}
		
		BorderPane borderPane = new BorderPane(new MainMenu());
		borderPane.setStyle("-fx-background-color: black");
		Scene loginScene = new Scene(borderPane, 400, 400);
		
		stage.setTitle("Personal Management System");
		//primaryStage.setMaximized(true);
		stage.setScene(loginScene);
		stage.show();
	}
	
	ArrayList<User> users= new ArrayList<User>();
	
	private void addUser(User user) throws UserAlreadyExistsException{
		if(!userExists(user.getUsername())){
			this.users.add(user);
		}
		else{
			throw new UserAlreadyExistsException(user.getUsername());
		}
	}
	
	private void addUser(String username, String password) throws UserAlreadyExistsException{
		if(!userExists(username)){
			this.users.add(new User(username, password));
		}
		else{
			throw new UserAlreadyExistsException(username);
		}
	}
	
	private boolean userExists(String username){
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}
	
	
	class MainMenu extends VBox{
		Button login = new Button("Login");
		Button newUser = new Button("New User");
		
		MainMenu(){
			this.setStyle("-fx-background-color: #39DEC2; -fx-border-color: grey; -fx-border-width: 12");
			this.setPrefSize(100, 50);
			this.setMaxSize(400, 200);
			this.setMinSize(100, 50);
			this.setAlignment(Pos.CENTER);
			
			login.setPrefSize(100, 25);
			login.setMinSize(100, 25);
			login.setMaxSize(100, 25);
			
			newUser.setPrefSize(100, 25);
			newUser.setMinSize(100, 25);
			newUser.setMaxSize(100, 25);
			
			this.getChildren().addAll(login, newUser);
		}
	}
	
	class LoginMenu extends GridPane{
		TextField username = new TextField();
		TextField password = new TextField();
		Label usernameLabel = new Label("Username: ");
		Label passwordLabel = new Label("Password: ");
		Label login = new Label("LOGIN");
		
		LoginMenu(){
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
			
			this.add(login, 0, 0);
			this.add(usernameLabel, 0, 1);
			this.add(passwordLabel, 0, 2);
			this.add(username, 1, 1);
			this.add(password, 1, 2);
		}
	}
}
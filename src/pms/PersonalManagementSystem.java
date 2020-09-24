package pms;

//import user.User;
//import myExceptions.*;
//import menu.*;
import calendar.Calendar;

//import java.util.ArrayList;

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
	public void start(Stage primaryStage){
		
		//BorderPane borderPane = new BorderPane();
		//borderPane.setStyle("-fx-background-color: black");
		Scene loginScene = new Scene(new Calendar(), 400, 325);
		
		primaryStage.setTitle("Personal Management System");
		primaryStage.setMinWidth(300);
		primaryStage.setMinHeight(300);
		primaryStage.setScene(loginScene);
		primaryStage.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
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
	}*/
}
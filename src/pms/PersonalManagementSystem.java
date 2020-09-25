package pms;

//import user.User;
//import myExceptions.*;
import menu.*;
import calendar.Calendar;

import java.time.*;

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
		Scene scene = new Scene(new Calendar()), 400, 325);
		
		primaryStage.setTitle("Personal Management System");
		primaryStage.setMinWidth(300);
		primaryStage.setMinHeight(300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
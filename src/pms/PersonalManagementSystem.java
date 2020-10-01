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

/**
 * <h2>PersonalManagementSystem</h2>
 * <p>This class drives the PersonalManagementSystem application.</p>
 * <p>Created on 1 October 2020</p>
 * @author Christian Harris
 */

public class PersonalManagementSystem extends Application{
	@Override
	/**
	*	This start method begins the application by creating a Calendar object and placing it in a scene. That scene is then added to the primary stage and shown
	*	successfully beginning the application.
	*/
	public void start(Stage primaryStage){
		Calendar calendar = new Calendar();
		Scene scene = new Scene(calendar, 800, 600);
		
		primaryStage.setTitle("Personal Management System");
		primaryStage.setMinWidth(300);
		primaryStage.setMinHeight(300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
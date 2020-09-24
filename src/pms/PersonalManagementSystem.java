package pms;

import user.User;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.geometry.Rectangle2D;

public class PersonalManagementSystem extends Application{
	@Override
	public void start(Stage primaryStage){
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane);
		
		primaryStage.setTitle("Personal Management System");
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	ArrayList<User> users= new ArrayList<User>();
	
	class loginMenu extends Pane{
		TextField username = new TextField();
		TextField password = new TextField();
	}
}
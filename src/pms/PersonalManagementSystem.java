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
		//Pane pane = new Pane();
		
		//Text text = new Text(50, 50, "Personal Management System");
		
		//pane.getChildren().add(text);
		
		//Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		//Scene scene = new Scene(pane, primaryScreenBounds.getWidth() + 200, primaryScreenBounds.getHeight() + 200);
		//Scene scene = new Scene(pane, 20, 20);

		//set Stage boundaries to visible bounds of the main screen
		//primaryStage.setX(primaryScreenBounds.getMinX());
		//primaryStage.setY(primaryScreenBounds.getMinY());
		//primaryStage.setWidth(primaryScreenBounds.getWidth());
		//primaryStage.setHeight(primaryScreenBounds.getHeight());
		
		primaryStage.setTitle("Personal Management System");
		primaryStage.setFullScreen(true);
		//primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	ArrayList<User> users= new ArrayList<User>();
	
	class loginMenu extends Pane{
		TextField username = new TextField();
		TextField password = new TextField();
	}
}
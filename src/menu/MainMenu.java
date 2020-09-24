package menu;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class MainMenu extends VBox{
	Button login = new Button("Login");
	Button newUser = new Button("New User");
	
	public MainMenu(){
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
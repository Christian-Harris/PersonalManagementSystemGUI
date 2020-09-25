package menu;

import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.time.*;

public class EventBuilderMenu extends GridPane{
	private TextField name;
	private TextField location;
	private TextField date;
	private ComboBox startTime;
	private ComboBox endTime;
	private TextArea description;
	private CheckBox repeats;
	private TextField startDate;
	private TextField endDate;
	
	private Button create;
	
	public EventBuilderMenu(LocalDate selectedDate){
		name = new TextField();
		name.setPromptText("Event Name");
		name.setPrefSize(200, 24);
		name.setMaxSize(200, 24);
		name.setMinSize(100, 24);
		
		location = new TextField();
		location.setPromptText("Location");
		location.setPrefSize(200, 24);
		location.setMaxSize(200, 24);
		location.setMinSize(100, 24);
		
		date = new TextField();
		date.setPromptText("Date");
		date.setPrefSize(200, 24);
		date.setMaxSize(200, 24);
		date.setMinSize(100, 24);
		
		startTime = new ComboBox<String>();
		
		endTime = new ComboBox<String>();
		
		description = new TextArea();
		description.setPrefSize(200, 200);
		description.setMaxSize(200, 200);
		description.setMinSize(100, 50);
		
		repeats = new CheckBox("Repeats");
		
		startDate = new TextField();
		startDate.setPromptText("Start Date");
		startDate.setPrefSize(200, 24);
		startDate.setMaxSize(200, 24);
		startDate.setMinSize(100, 24);
		
		endDate = new TextField();
		endDate.setPromptText("End Date");
		endDate.setPrefSize(200, 24);
		endDate.setMaxSize(200, 24);
		endDate.setMinSize(100, 24);
		
		create = new Button("Create");
		
		EventBuilderToolbar toolbar = new EventBuilderToolbar();
		
		this.add(toolbar, 0, 0);
		
		this.add(new Label("Name: "), 0, 1);
		this.add(name, 1, 1);
		
		this.add(new Label("Location: "), 0, 2);
		this.add(location, 1, 2);
		
		this.add(new Label("Date: "), 0, 3);
		this.add(date, 1, 3);
		
		this.add(new Label("Start Time: "), 0, 4);
		this.add(startTime, 1, 4);
		
		this.add(new Label("End Time: "), 0, 5);
		this.add(endTime, 1, 5);
		
		this.add(new Label("Description"), 0, 6);
		this.add(description, 0, 7, 2, 2);
		
		this.add(repeats, 3, 1);
		
		this.add(new Label("Start Date: "), 3, 2);
		this.add(startDate, 4, 2);
		
		this.add(new Label("End Date: "), 3, 3);
		this.add(endDate, 4, 3);
		
		this.paintEventBuilderMenu();
	}
	
	private void paintEventBuilderMenu(){
		
	}
	
	class EventBuilderToolbar extends HBox{
		Button back;
		
		public EventBuilderToolbar(){
			back = new Button("<-");
			this.getChildren().add(back);
		}
	}
}